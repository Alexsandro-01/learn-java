package com.sistemarh;

/**
 * Classe representando Pessoa Colaboradora.
 */
public class PessoaColaboradora {

  protected double salarioBruto;

  /**
   * Método para cálculo salário líquido
   * do funcionário.
   *
   * @return sálario liquido depois de descontado o importo.
   */
  public double calcularSalarioLiquido() {
    double twentyPercent = salarioBruto / 5;

    return salarioBruto - twentyPercent;
  }

  public double calcularValorBrutoRecebidoAnual(int ano) {
    return salarioBruto * (ano * 12);
  }

  /**
   * Método para cálculo valor líquido que um funcionário
   * receberia em um número x de anos.
   *
   * @param ano quantidade de anos a ser caculada.
   * @return resultado da multiplicação do salário liquido pelos anos.
   */
  public double calcularValorLiquidoRecebidoAnual(int ano) {
    double twentyPercent = salarioBruto / 5;
    double salarioLiquido = salarioBruto - twentyPercent;

    return salarioLiquido * (ano * 12);
  }

  /**
   * Método calcula o valor em imposto que um funcionário pagaria em
   * uma quantiodade x de anos.
   *
   * @param ano quantidade de anos a ser calculada.
   * @return resultado da operação.
   */
  public double calcularValorImpostoAnual(int ano) {
    double twentyPercent = salarioBruto / 5;

    return twentyPercent * (ano * 12);
  }

  public double getSalarioBruto() {
    return salarioBruto;
  }

  public void setSalarioBruto(double salarioBruto) {
    this.salarioBruto = salarioBruto;
  }

}
