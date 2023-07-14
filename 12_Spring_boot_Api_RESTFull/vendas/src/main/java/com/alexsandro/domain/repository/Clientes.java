package com.alexsandro.domain.repository;

import com.alexsandro.domain.entity.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The interface Clientes.
 */
// Nos parâmetros de <Cliente, Integer>, Cliente é a classe a ser recebida e Integer é
// o tipo do Identificador da Classe, o Id, que nesse caso é do tipo integer.
public interface Clientes extends JpaRepository<Cliente, Integer> {
  // QueryMethods pesquise por;

  /**
   * Covenção usada pela JpaRepository para criar métodos personalizados
   * find = procurar,
   *  By = por,
   *  Nome = nome da coluna na minha entidade Cliente,
   *  Like = tipo de procura
   * Seguindo essa convenção a aplicação cria a consulta para mim sem eu precisar implementar nada.
   *
   * @param nome valor a ser encontrado na tabela.
   * @return Lista de Clientes encontrados.
   */
  List<Cliente> findByNomeLike(String nome);

  /**
   * find = procurar,
   *  By = por,
   *  Nome = coluna na minha entidade,
   *  Or = ou,
   *  Id = coluna na minha entidade.
   *
   * @param nome valor a ser procurado na tabela.
   * @param id valor a ser procurado na tabela.
   * @return lista de clientes encontrados.
   */
  List<Cliente> findByNomeOrId(String nome, Integer id);

  @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
  Cliente findClienteFecthPedidos(@Param("id") Integer id);
}
