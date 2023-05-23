import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class para praticaar criação de Stream().
 */
public class CriadorStream {
  public <T> Stream<T> criarDoItem(T item) {
    return Stream.of(item);
  }

  public <T> Stream<T> criarDoArray(T[] array) {
    return Arrays.stream(array);
  }

  public <T> Stream<T> criarDaLista(List<T> lista) {
    return lista.stream();
  }

}
