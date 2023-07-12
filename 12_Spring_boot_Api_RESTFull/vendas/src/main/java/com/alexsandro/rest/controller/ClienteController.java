package com.alexsandro.rest.controller;

import com.alexsandro.domain.entity.Cliente;
import com.alexsandro.domain.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

  private final Clientes clientes;

  public ClienteController( Clientes clientes ) {
    this.clientes = clientes;
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity<List<Cliente>> find( Cliente filtro ) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase() //ignora uprcase e lowarcase
        .withStringMatcher(
            ExampleMatcher.StringMatcher.CONTAINING // não lembro
        );

    Example<Cliente> example = Example.of(filtro, matcher); // filtra usando o matcher
    List<Cliente> list = clientes.findAll(example);

    return ResponseEntity.ok(list);
    // usa os param de url para filtrar os clientes
    // se não houver param, retorna todos os clientes
    // se houver ex: .../clientes?nome=a vai retornar todos
    // clientes que começam com 'a' independente se 'a' ou 'A'
  }


  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Cliente> getClienteById( @PathVariable Integer id ) {
    Optional<Cliente> cliente = clientes.findById(id);

    return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
    Cliente savedCliente = clientes.save(cliente);

    return ResponseEntity.ok(savedCliente);
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity delete(@PathVariable Integer id) {
    Optional<Cliente> cliente = clientes.findById(id);

    if (cliente.isPresent()) {
      clientes.delete(cliente.get());

      return ResponseEntity.noContent().build();
    }

    return  ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  @ResponseBody
  public ResponseEntity update(
      @PathVariable Integer id
      , @RequestBody Cliente cliente
  ) {
    // maneira diferente de tratar a requisição
    return clientes.findById(id)
        .map((clienteExistente) -> { // Optional possui o método map()
          cliente.setId(clienteExistente.getId()); // pega o id do cliente exentente e põe no update
          clientes.save(cliente); // salva o update que vai sobreescrever o antigo
          return ResponseEntity.noContent().build(); // isso a gente já manja
        })
        .orElseGet(() -> ResponseEntity.notFound().build()); // caso cliente não exista, executa o orElse()
  }
}
