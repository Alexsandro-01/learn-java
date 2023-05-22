/**
 * Classe do desafio.
 */
public class Show {

  /**
   * Método do desafio.
   */
  public boolean permitirEntrada(int idade) throws PessoaMenorDeIdadeException {
    // Altere este método
    if (idade < 18) {
      throw new PessoaMenorDeIdadeException("Pessoa menor de idade!");
    }

    return true;
  }
}


