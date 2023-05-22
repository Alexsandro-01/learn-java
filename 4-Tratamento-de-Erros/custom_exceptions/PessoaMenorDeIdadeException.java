/**
 * Classe para lançamento de erros customizados
 * qunado usuário for menor de idade.
 */
public class PessoaMenorDeIdadeException extends Exception {
  /**
   * Método construtor da classe.
   *
   * @param message mensagem a ser exibida ao lançar a exceção.
   */
  PessoaMenorDeIdadeException(String message) {
    super(message);
  }
}