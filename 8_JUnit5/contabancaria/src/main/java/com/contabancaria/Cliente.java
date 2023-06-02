package com.contabancaria;

/**
 * Classe Cliente.
 **/
public class Cliente {

  private String nome;
  private String cpf;

  public String getCpf() {
    return cpf;
  }

  /**
   * Caso cpf passado como parâmetro seja válido adiciona-o ao atributo cpf,
   * caso contrário adiciona null.
   *
   * @param cpf cpf da pessoa usuária.
   */
  public void setCpf(String cpf) {
    if (ValidaCpf.validarCpf(cpf)) {
      this.cpf = cpf;
    } else {
      this.cpf = null;
    }
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
