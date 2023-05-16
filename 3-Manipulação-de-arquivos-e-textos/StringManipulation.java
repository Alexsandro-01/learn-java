/**
 * Class para exibição de String formatada.
 */
public class StringManipulation {
  /**
   * Método principal.
   *
   * @param args argumentos não utilizados.
   */
  public static void main(String[] args) {
    StringManipulation str = new StringManipulation();

    str.showTransaction("123.45MCAD");
  }

  /**
   * Método para realizar a formatação da String
   * para exibição.
   *
   * @param info string para ser formatada.
   */
  public void showTransaction(String info) {
    String[] result = info.split("M");

    String value = result[0];
    String currency = result[1];

    System.out.println("$" + value + " - " + currency);
  }
}
