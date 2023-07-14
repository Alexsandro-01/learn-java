package com.alexsandro.rest.controller;

import com.alexsandro.domain.entity.Cliente;
import com.alexsandro.domain.repository.Clientes;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


/**
 * The type Cliente controller.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

  private final Clientes clientes;

  public ClienteController(Clientes clientes) {
    this.clientes = clientes;
  }

  /**
   * Find response entity.
   *
   * @param filtro propriedades do cliente para usar na filtragem
   * @return the response entity
   */
  @GetMapping
  public List<Cliente> find(Cliente filtro) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase() //ignora uprcase e lowarcase
        .withStringMatcher(
            ExampleMatcher.StringMatcher.CONTAINING // não lembro
        );

    Example<Cliente> example = Example.of(filtro, matcher); // filtra usando o matcher

    return clientes.findAll(example);
    // usa os param de url para filtrar os clientes
    // se não houver param, retorna todos os clientes
    // se houver ex: .../clientes?nome=a vai retornar todos
    // clientes que começam com 'a' independente se 'a' ou 'A'
  }


  /**
   * Gets cliente by id.
   *
   * @param id the id
   * @return the cliente by id
   */
  @GetMapping("/{id}")
  public Cliente getClienteById(@PathVariable Integer id) {
    return clientes
        .findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
        );
  }

  /**
   * Save a new Cliente on BD.
   *
   * @param cliente the cliente to save
   * @return the response entity
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED) // retorna um código de status pre definido
  public Cliente save(@RequestBody Cliente cliente) {
    return clientes.save(cliente);
  }

  /**
   * Delete a Cliente by id.
   *
   * @param id the id
   */
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    clientes.findById(id)
        .map(cliente -> {
          clientes.delete(cliente);
          return cliente;
        })
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado")
        );
  }

  /**
   * Update a Cliente.
   *
   * @param id      the id
   * @param cliente the cliente
   */
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(
      @PathVariable Integer id,
      @RequestBody Cliente cliente
  ) {
    // maneira diferente de tratar a requisição
    clientes.findById(id)
        .map((clienteExistente) -> { // Optional possui o método map()
          cliente.setId(clienteExistente.getId()); // pega o id do cliente exentente e põe no update
          clientes.save(cliente); // salva o update que vai sobreescrever o antigo
          return clienteExistente; // isso a gente já manja
        })
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
        ); // caso cliente não exista, executa o orElse()
  }
}
