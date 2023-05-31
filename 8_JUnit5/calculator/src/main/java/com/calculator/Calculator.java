package com.calculator;


/**
 * Classe Calculadora.
 */
public class Calculator {

  /**
   * Método principal.
   *
   * @param args não usado.
   */
  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    System.out.println(calculator.sum(2, 2));
  }

  /**
   * Método para realizar soma de dois numeros.
   *
   * @param num1 primeiro numero para ser somado.
   * @param num2 segundo numero para ser somado.
   * @return resultado da soma.
   */
  public double sum(double num1, double num2) {
    return num1 + num2;
  }

  /**
   * Método para realizar subtração de dois numeros.
   *
   * @param num1 primerio numero para realizar a subtração.
   * @param num2 segundo numero para realizar a subtração.
   * @return resultado da subtração.
   */
  public double sub(double num1, double num2) {
    return num1 - num2;
  }

  /**
   * Método para realizar divisão de dois numeros.
   *
   * @param num1 numero a ser dividido.
   * @param num2 numero que será o divisor.
   * @return resultado da divisão.
   */
  public double div(double num1, double num2) {
    if (verifyDivider(num2)) {
      return num1 / num2;
    }

    return 0;
  }

  public boolean verifyDivider(double divider) {
    return divider != 0;
  }
}
