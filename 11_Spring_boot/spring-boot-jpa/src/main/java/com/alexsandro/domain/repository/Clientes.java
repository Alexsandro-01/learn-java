package com.alexsandro.domain.repository;

import com.alexsandro.domain.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

  @Autowired
  private EntityManager entityManager;

  @Transactional // importar o do pacote do Springframework
  public Cliente salvar(Cliente cliente) {
    entityManager.persist(cliente);
    return cliente;
  }

  @Transactional
  public Cliente atualizar(Cliente cliente) {
    entityManager.merge(cliente);

    return cliente;
  }

  @Transactional(readOnly = true) // indica que é uma busca apenas leitura, para otimizar o processo
  public List<Cliente> buscarPorNome(String nome) {
    String jpql = " select c from Cliente c where c.nome = :nome ";
     TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);

     query.setParameter("nome", "%" + nome + "%");
     return query.getResultList();
  }

  @Transactional
  public List<Cliente> obterTodos() {
    TypedQuery<Cliente> query = entityManager.createQuery("from Cliente", Cliente.class);

    return query.getResultList();
  }

  @Transactional
  public void deletar(Cliente cliente) {
    // ocorreu um erro de "Removing a detached instance" enquanto rodava a aplicação
    // ocorre que é necessário adicionar o obj ao entityManager antes de removê-lo do BD
    // https://stackoverflow.com/questions/17027398/java-lang-illegalargumentexception-removing-a-detached-instance-com-test-user5
    if (!entityManager.contains(cliente)) {
      cliente = entityManager.merge(cliente);
    }
    entityManager.remove(cliente);
  }

  @Transactional
  public void deletar(Integer id) {
    Cliente cliente = entityManager.find(Cliente.class, id);
    deletar(cliente);
  }

}
