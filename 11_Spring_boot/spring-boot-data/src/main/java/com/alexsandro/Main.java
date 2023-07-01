package com.alexsandro;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alexsandro.domain.entity.Cliente;
import com.alexsandro.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {

  @Bean
  public CommandLineRunner init(@Autowired Clientes clientes) {
    return args -> {
      System.out.println("Adicionando clientes");
      clientes.save(new Cliente("Alexsandro Pinheiro"));
      clientes.save(new Cliente("Serena Pinheiro"));

      System.out.println("Listando clientes");
      List<Cliente> todosClientes = clientes.findAll();
      todosClientes.forEach(System.out::println);

      System.out.println("Atualizando os clientes");
      List<Cliente> clientesToUpdate = clientes.findAll();
      clientesToUpdate.forEach(c -> {
        c.setNome(c.getNome() + " updated");

        // o save() tanto salva quanto atualiza
        clientes.save(c);
      });

      System.out.println("Clientes atualizados");
      List<Cliente> todosClientesUpdated = clientes.findAll();
      todosClientesUpdated.forEach(System.out::println);

      System.out.println("Deletando os clientes");
      List<Cliente> clientesToDelete = clientes.findAll();
      clientesToDelete.forEach(c -> {
        clientes.delete(c);
      });

      System.out.println("Clientes deletados");
      List<Cliente> todosClientesDeleted = clientes.findAll();
      if (todosClientesDeleted.isEmpty()) {
        System.out.println("Nenhum dado encontrado");
      } else {
      todosClientesDeleted.forEach(System.out::println);
      }
    };
  }
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}