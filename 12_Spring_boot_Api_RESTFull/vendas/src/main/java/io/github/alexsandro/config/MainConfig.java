package io.github.alexsandro.config;

import io.github.alexsandro.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * Class de configuração da aplicação.
 */
@Environment
public class MainConfig {

  @Value("${application.name}")
  private String profile;

  /**
   * método de linha de comando.
   *
   * @return imprime texto linha de comando.
   */
  @Bean // quando a aplicação sobre, ela procura os @Beans com CommandLineRunner e executa.
  public CommandLineRunner run() {
    return args -> {
      System.out.println(
          "Server running " + profile
      );
    };
  }
}
