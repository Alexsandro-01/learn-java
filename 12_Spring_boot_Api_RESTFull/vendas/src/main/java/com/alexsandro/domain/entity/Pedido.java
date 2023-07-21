package com.alexsandro.domain.entity;

import com.alexsandro.domain.enums.StatusPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

/**
 * The type Pedido.
 */
@Entity
@Table(name = "pedido")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @Column(name = "data_pedido")
  private LocalDate dataPedido;

  // precicion = quantidade de digitos suportada pelo total
  // scale = quantidade de numeros após a virgula
  @Column(name = "total", precision = 20, scale = 2)
  private BigDecimal total;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private StatusPedido status;

  @OneToMany(mappedBy = "pedido")
  private Set<ItemPedido> itens;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public LocalDate getDataPedido() {
    return dataPedido;
  }

  public void setDataPedido(LocalDate dataPedido) {
    this.dataPedido = dataPedido;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public Set<ItemPedido> getItens() {
    return itens;
  }

  public void setItens(Set<ItemPedido> itens) {
    this.itens = itens;
  }

  public StatusPedido getStatus() {
    return status;
  }

  public void setStatus(StatusPedido status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Pedido{"
        + "id=" + id
        + ", dataPedido=" + dataPedido
        + ", total=" + total
        + '}';
  }
}
