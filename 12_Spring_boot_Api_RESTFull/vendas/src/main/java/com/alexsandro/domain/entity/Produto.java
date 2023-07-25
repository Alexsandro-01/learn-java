package com.alexsandro.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * The type Produto.
 */
@Entity
@Table(name = "produto")
public class Produto {

  // o uso do @NotNull pediu pra inicializar a variável no construtor.
  public Produto() {
    preco = null;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "descricao")
  @NotEmpty(message = "Campo descrição é obrigatório.")
  private String descricao;

  @Column(name = "preco_unitario")
  @NotNull(message = "Campo preço é obrigatório.")
  private BigDecimal preco;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }
}
