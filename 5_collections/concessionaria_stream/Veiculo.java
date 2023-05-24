/**
 * Classe Veiculo fornecida pela Trybe para resolução
 * do exercício, não foi desenvolvida por mim.
 */
public class Veiculo {
  private String nome;

  public Veiculo(String nome) {
      this.nome = nome;
  }

  /**
   * @return
   * @see java.lang.Object#hashCode()
   * @Override
   */
  @Override
  public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
      return result;
  }

  /**
   * @param obj
   * @return
   * @see java.lang.Object#equals(java.lang.Object)
   * @Override
   */
  @Override
  public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Veiculo other = (Veiculo) obj;
      if (nome == null) {
        if (other.nome != null)
          return false;
        } else if (!nome.equals(other.nome))
           return false;
        return true;
  }

  /**
   * @return
   * @see java.lang.Object#toString()
   * @Override
   */
  @Override
  public String toString() {
    return "Veiculo: " + nome;
  }
  
}
