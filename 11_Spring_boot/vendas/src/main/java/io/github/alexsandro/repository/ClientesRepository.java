package io.github.alexsandro.repository;

import io.github.alexsandro.model.Cliente;
import org.springframework.stereotype.Repository;

/**
 * classe de conexão com BD.
 */
@Repository
public class ClientesRepository {
  public void persistir(Cliente cliente) {
    //persiste o cliente no baco
  }
}
