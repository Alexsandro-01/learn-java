package com.sistemarh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaColaboradoraTest {


  @Test
  @DisplayName("1. Ao setar 1500 como salário bruto o método retorna 1300")
  public void testeCalcularSalarioLiquido() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(1500);

    assertEquals(1200, colaborador.calcularSalarioLiquido());
  }


  @Test
  @DisplayName("2. Ao setar 1500 como salário e passar 3 anos, o metódo retorna 54000")
  public void testeCalcularValorBrutoRecebidoAnual() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(1500);

    assertEquals(54000, colaborador.calcularValorBrutoRecebidoAnual(3));
  }


  @Test
  @DisplayName("3. Ao setar 1500 como salário e passar 3 anos, o método retorna 43200")
  public void testeCalcularValorLiquidoRecebidoAnual() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(1500);

    assertEquals(43200, colaborador.calcularValorLiquidoRecebidoAnual(3));
  }


  @Test
  @DisplayName("4. Ao setar 1500 como salário e passar 3 anos, o método retorna 10800")
  public void testeCalcularValorImpostoAnual() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(1500);

    assertEquals(10800, colaborador.calcularValorImpostoAnual(3));
  }

}
