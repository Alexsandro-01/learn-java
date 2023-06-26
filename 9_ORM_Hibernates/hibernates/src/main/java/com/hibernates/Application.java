package com.hibernates;
import com.hibernates.entity.Veiculo;


/**
 * Class principal da aplicação.
 */
public class Application {

  /**
   * Método principal.
   *
   * @param args argumentos da linha de comando.
   */
  public static void main(String[] args) {

    // dados
    Veiculo veiculo = new Veiculo();
    veiculo.setAno(2016);
    veiculo.setModelo("Fusca");
    veiculo.setQuilometragem("45677");

    VeiculoService service = new VeiculoService();

    service.save(veiculo);

    // =====================

    System.out.println(
      service.getVeiculos().size()
    ); // imprime 1

    VeiculoService newService = new VeiculoService();

    System.out.println(
      newService.getVeiculos().size()
    ); // imprime 1
  }
}
