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
      clientes.salvar(new Cliente("Alexsandro Pinheiro"));
      clientes.salvar(new Cliente("Serena Pinheiro"));

      System.out.println("Listando clientes");
      List<Cliente> todosClientes = clientes.obterTodos();
      todosClientes.forEach(System.out::println);

      System.out.println("Atualizando os clientes");
      List<Cliente> clientesToUpdate = clientes.obterTodos();
      clientesToUpdate.forEach(c -> {
        c.setNome(c.getNome() + " updated");
        clientes.atualizar(c);
      });

      System.out.println("Clientes atualizados");
      List<Cliente> todosClientesUpdated = clientes.obterTodos();
      todosClientesUpdated.forEach(System.out::println);

      System.out.println("Deletando os clientes");
      List<Cliente> clientesToDelete = clientes.obterTodos();
      clientesToDelete.forEach(c -> {
        clientes.deletar(c);
      });

      System.out.println("Clientes deletados");
      List<Cliente> todosClientesDeleted = clientes.obterTodos();
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