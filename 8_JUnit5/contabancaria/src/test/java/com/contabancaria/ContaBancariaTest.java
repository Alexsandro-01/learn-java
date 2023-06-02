package com.contabancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContaBancariaTest {

  @Test
  @DisplayName("4 - Deve retornar o nome de do cliente cadastrado corretamente")
  public void testeNomeCliente() {
    ContaBancaria contaBancaria = new ContaBancaria();
    contaBancaria.setNomeCliente("Jilmar Mendes");
    assertEquals("Jilmar Mendes", contaBancaria.getNomeCliente());
  }

  @Test
  @DisplayName("5 - Deve retornar o cpf do cliente corretamente caso um cpf válido tenha sido cadastrado")
  public void testeCPFClienteValido() {
    ContaBancaria contaBancaria = new ContaBancaria();
    contaBancaria.setCpfCliente("02758787083");
    assertEquals("02758787083", contaBancaria.getCpfCliente());
  }

  @Test
  @DisplayName("6 - Deve retornar null caso um cpf inválido tenha sido cadastrado")
  public void testeCPFClienteinValido() {
    ContaBancaria contaBancaria = new ContaBancaria();
    contaBancaria.setCpfCliente("02758787089");
    assertNull(contaBancaria.getCpfCliente());
  }

  @Test
  @DisplayName("7 - O métod depositar deposita o dinherio corretamente, somando o depósito ao saldo presente")
  public void testeDepositar() {
    ContaBancaria contaBancaria = new ContaBancaria();
    assertEquals(1500, contaBancaria.depositar(1500));
  }

  @Test
  @DisplayName("8 - O métod sacar saca o dinherio corretamente, subtraindo o saque do saldo presente")
  public void testeSacar() {
    ContaBancaria contaBancaria = new ContaBancaria();
    contaBancaria.depositar(1500);
    assertEquals(750, contaBancaria.sacar(750));
  }

  @Test
  @DisplayName("9 - Deve retornar o saldo na conta")
  public void testeVerSaldo() {
    ContaBancaria contaBancaria = new ContaBancaria();
    contaBancaria.depositar(5000);
    assertEquals(5000, contaBancaria.verSaldo());
  }
}
