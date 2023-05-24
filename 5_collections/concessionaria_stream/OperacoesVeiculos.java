import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe representa algumas operações
 * referentes a venda de veículos.
 */
public class OperacoesVeiculos {

  /**
   * Essa operação recebe um Stream de veículos vendidos,
   * para dizer quantos veículos diferentes foram vendidos.
   *
   * @param veiculosVendidos um Stream de veículos vendidos.
   * @param <T> Parâmetro génerico.
   * @return quantidade de veículos diferentes vendidos.
   */
  public <T> int numVeiculosDiferentesVendidos(Stream<T> veiculosVendidos) {
    long numVeicles = veiculosVendidos
        .distinct()
        .count();

    return (int) numVeicles;
  }

  /**
   * Essa operação recebe um Stream de veículos, e você vai retornar um Stream do mesmo tamanho,
   * mas de String.
   *
   * @param veiculos stream do objeto Veículo.
   * @param <T> Parâmetro génerico.
   * @return retornar um Stream do mesmo tamanho recebido, mas de String.
   */
  public <T> Stream<String> obterRepresentacao(Stream<T> veiculos) {
    return veiculos
        .map(Object::toString);
  }

  /**
   * A operação obterLista deve apenas retornar um List
   * com os mesmos elementos do Stream passado como parâmetro.
   *
   * @param veiculos stream do objeto Veículo.
   * @param <T> Parâmetro genérico.
   * @return lista com os mesmos elementos recebidos como parâmetro.
   */
  public <T> List<T> obterLista(Stream<T> veiculos) {
    return veiculos
        .collect(Collectors.toList());
  }

}
