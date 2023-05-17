/**
 * CLasse para manipulação e tratametno de String.
 */
public class Texto {

  /**
   * Método para alteração de texto com base em regras pré-estabelecidas.
   *
   * @param frase texto a ser alterado.
   * @return texto alterado.
   */
  public String transformaTexto(String frase) {
    String removeSymble = frase.replace("+", " ");

    int indexA = removeSymble.indexOf("a");

    if (indexA % 2 == 0) {
      return removeSymble.toUpperCase();
    } else {
      return removeSymble.split(" ")[0];
    }
  }
}

