package com.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Classe Calculadora")
public class CalculatorTest {

  Calculator calculator = new Calculator();

  @Test
  @DisplayName("1 - O método sum() deve somar os números passados como parâmetros")
  public void sumTeste() {
    assertEquals(4.0, this.calculator.sum(2, 2));
  }

  @Test
  @DisplayName("2 - O método sub() deve subtrair o primeriro parâmetro do segundo parâmetro")
  public void subTest() {
    assertEquals(-1.0, this.calculator.sub(2, 3));
  }

  @Test
  @DisplayName("3 - O método div() deve retornar a divisão do 1º parâmetro pelo 2º parâmetro")
  void divTest() {
    assertEquals(8, calculator.div(40, 5));
  }

  @Test
  @DisplayName("4 - O método div() deve retornar 0 caso o 2º parâmetro seja 0")
  void divByZeroTest() {
    assertEquals(0, calculator.div(40, 0));
  }

  @Test
  @DisplayName("5 - Método verifyDivider() deve retornar true caso o parâmetro passado seja diferente de 0")
  void verifyDividerTest() {
    assertTrue(calculator.verifyDivider(5));
  }

  @Test
  @DisplayName("5 - Método verifyDivider() deve retornar true caso o parâmetro passado seja diferente de 0")
  void verifyDividerReturnsFalseTest() {
    assertFalse(calculator.verifyDivider(0));
  }
}
