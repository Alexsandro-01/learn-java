package io.github.alexsandro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class principal da Aplicação.
 */
@SpringBootApplication
@RestController
public class Main {

  @Value("${application.name}")
  private String applicationName;

  @GetMapping("/hello")
  public String helloWord() {
    return applicationName;
  }

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}