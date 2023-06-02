package com.contabancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {
  @Test
  @DisplayName("1 - Deve cadastrar e retornar o nome do cliente corretamente")
  public void testeNome() {
    Cliente cliente = new Cliente();
    cliente.setNome("Jilmar Mendes");
    assertEquals("Paulo Roberto", cliente.getNome());
  }

  @Test
  @DisplayName("2 - Deve salvar e retornar um cpf válido corretamente")
  public void testeSetCPFValido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("02758787083");
    assertEquals("02758787083", cliente.getCpf());
  }

  @Test
  @DisplayName("3 - Deve retornar null caso um cpf inválido tenha sido passado")
  public void testeSetCPFInvalido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("02758787089");
    assertNull(cliente.getCpf());
  }

}
