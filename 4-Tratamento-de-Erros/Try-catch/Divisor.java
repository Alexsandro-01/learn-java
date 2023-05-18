/**
 * Classe para exercicitar o tratamento de erros com
 * o bloco try/catch.
 */
public class Divisor {

  /**
   * Método calcula a divisão entre dois numeros, além de capturar
   * erros de divisão por 0, tratando-os e retornando 0.
   *
   * @param number1 primeiro numero para a divisão.
   * @param number2 segundo numero para a divisão.
   * @return resultado da divisão dos dois números.
   */
  public int dividir(int number1, int number2) {
    try {
      return number1 / number2;
    } catch (ArithmeticException exception) {
      return 0;
    }
  }

}
