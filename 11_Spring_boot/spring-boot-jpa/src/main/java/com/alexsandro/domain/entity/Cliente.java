package com.alexsandro.domain.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "cliente") // só é necessária caso o nome da tabela seja diferente do nome da class
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id") // não é obrigatório caso o nome da coluna seja igual ao da tabela
  private Integer id;

  @Column(name = "nome", length = 50)
  private String nome;

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

  @Override
  public String toString() {
    return "Cliente{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        '}';
  }
}
