import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma agenda, mas por enquanto
 * guarda apenas nomes.
 */
public class Agenda {
  private final List<String> contatos = new ArrayList<>();

  public void incluirContato(String name) {
    contatos.add(name);
  }

  public void excluirContato(String name) {
    contatos.remove(name);
  }

  public boolean verificaContato(String name) {
    return contatos.contains(name);
  }

  public int tamanhoAgenda() {
    return contatos.size();
  }
}
