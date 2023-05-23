import java.util.HashMap;
import java.util.Map;

/**
 * Classe de criação de uma agenda utilizando MAP.
 */
public class AgendaMapa {

  Map<String, String> agenda = new HashMap<>();

  public void incluirContato(String nome, String telefone) {
    agenda.put(nome, telefone);
  }

  public void excluirContato(String nome) {
    agenda.remove(nome);
  }

  public boolean verificaContato(String nome) {
    return agenda.containsKey(nome);
  }

  public int tamanhoAgenda() {
    return agenda.size();
  }

  public void atualizarTelefone(String nome, String telefone) {
    agenda.put(nome, telefone);
  }

  public String obterTelefone(String nome) {
    return agenda.get(nome);
  }
}
