package com.alexsandro.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

/**
 * The type Cliente.
 */
@Entity
@Table(name = "cliente") // só é necessária caso o nome da tabela seja diferente do nome da class
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id") // não é obrigatório caso o nome da coluna seja igual ao da tabela
  private Integer id;

  @Column(name = "nome", length = 50)
  @NotEmpty(message = "Campo nome é obrigatório")
  private String nome;

  @JsonIgnore // ignora os pedidos quando requisitamos apenas os clientes
  @OneToMany(mappedBy = "cliente")
  private Set<Pedido> pedidos;

  public Cliente() {}

  public Cliente(String nome) {
    this.nome = nome;
  }

  public Cliente(Integer id, String nome) {
    this.nome = nome;
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(Set<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  @Override
  public String toString() {
    return "Cliente{"
        + "id=" + id
        + ", nome='" + nome + '\''
        + '}';
  }
}
