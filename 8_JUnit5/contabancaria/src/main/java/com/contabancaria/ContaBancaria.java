package com.contabancaria;

/**
 * Classe ContaBancaria.
 **/

public class ContaBancaria {

  /**
   * Atributos.
   **/
  private int saldo;
  private Cliente cliente;

  /**
   * Métodos.
   **/

  ContaBancaria() {
    this.saldo = 0;
    this.cliente = new Cliente();
  }

  public void setNomeCliente(String nome) {
    this.cliente.setNome(nome);
  }

  public String getNomeCliente() {
    return this.cliente.getNome();
  }

  public void setCpfCliente(String cpf) {
    this.cliente.setCpf(cpf);
  }

  public String getCpfCliente() {
    return this.cliente.getCpf();
  }

  public int depositar(int deposito) {
    this.saldo += deposito;
    return this.saldo;
  }

  /**
   * realiza o saque da quantia informada pelo usuário,
   * caso o valor do saque seja menor ou igual ao saldo.
   *
   * @param saque quantia a ser sacada.
   * @return novo saldo após o saque.
   */
  public int sacar(int saque) {
    if (this.saldo >= saque) {
      this.saldo -= saque;
      return this.saldo;
    }

    return this.saldo;
  }

  public int verSaldo() {
    return this.saldo;
  }
}
