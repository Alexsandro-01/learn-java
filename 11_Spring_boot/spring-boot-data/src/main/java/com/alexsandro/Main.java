package com.alexsandro;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alexsandro.domain.entity.Cliente;
import com.alexsandro.domain.entity.Pedido;
import com.alexsandro.domain.repository.Clientes;
import com.alexsandro.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Main {

  @Bean
  public CommandLineRunner init(
      @Autowired Clientes clientes,
      @Autowired Pedidos pedidos
  ) {
    return args -> {
      System.out.println("Adicionando clientes");
      Cliente alexsandro = new Cliente("Alexsandro Pinheiro");
      clientes.save(alexsandro);

      Pedido pedido = new Pedido();
      pedido.setCliente(alexsandro);
      pedido.setDataPedido(LocalDate.now());
      pedido.setTotal(BigDecimal.valueOf(100));

      pedidos.save(pedido);

//      Cliente alexWithOrders = clientes.findClienteFecthPedidos(alexsandro.getId());
//      System.out.println(alexWithOrders);
//      System.out.println(alexWithOrders.getPedidos());

      pedidos.findByCliente(alexsandro).forEach(System.out::println);
    };
  }
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}