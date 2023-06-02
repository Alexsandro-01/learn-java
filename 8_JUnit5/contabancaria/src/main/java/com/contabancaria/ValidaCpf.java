package com.contabancaria;

/**
 * Classe ValidaCpf.
 **/
public class ValidaCpf {

  /**
   * Método para validar se um cpf possui o formato válido.
   *
   * @param cpf cpf a ser verificado.
   * @return true ou false de acordo com a cverificação.
   */
  public static boolean validarCpf(String cpf) {
    if (cpf.length() < 10) {
      return false;
    }

    String checkCode = cpf.substring(cpf.length() - 2);

    int firstDv = ValidaCpf.findFirstDv(cpf);
    int secondDv = ValidaCpf.findSecondDv(cpf);

    String code = firstDv + Integer.toString(secondDv);

    return checkCode.equals(code);
  }

  private static int findFirstDv(String cpf) {
    int amount = 0;
    int stringIndex = 0;

    for (int index = 10; index >= 2; index--) {
      char currentChar = cpf.charAt(stringIndex);
      int currentDigit = Character.getNumericValue(currentChar);

      amount += currentDigit * index;
      stringIndex += 1;
    }

    int firstDv = 11 - (amount % 11);

    return (firstDv == 11 || firstDv == 10) ? 0 : firstDv;
  }

  private static int findSecondDv(String cpf) {
    int amount = 0;
    int stringIndex = 0;

    for (int index = 11; index >= 2; index--) {
      char currentChar = cpf.charAt(stringIndex);
      int currentDigit = Character.getNumericValue(currentChar);

      amount += currentDigit * index;
      stringIndex += 1;
    }

    int secondDv = 11 - (amount % 11);

    return (secondDv == 11 || secondDv == 10) ? 0 : secondDv;
  }

}
