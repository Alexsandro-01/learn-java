package com.contabancaria;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidaCPFTest {

  @Test
  @DisplayName("2 - Método deve retornar true caso um cpf válido seja passado")
  public void testeValidarCPFValido() {
    assertTrue(ValidaCpf.validarCpf("02758787083"));
  }

  @Test
  @DisplayName("3 - Método deve retornar false caso um cpf inválido seja passado")
  public void testeValidarCPFinValido() {
    assertFalse(ValidaCpf.validarCpf("02758787087"));
  }

}
