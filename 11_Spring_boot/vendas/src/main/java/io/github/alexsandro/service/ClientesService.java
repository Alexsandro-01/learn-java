package io.github.alexsandro.service;

import io.github.alexsandro.model.Cliente;
import io.github.alexsandro.repository.ClientesRepository;
import org.springframework.stereotype.Service;

/**
 * Class camada de Service do cliente.
 */
@Service
public class ClientesService {

  private final ClientesRepository repository;

  /**
   * Método construtor da Classe.
   *
   * @param repository classe repository do sistema.
   */
  public ClientesService(ClientesRepository repository) {
    this.repository = repository;
  }

  public void salvarCliente(Cliente cliente) {
    validarCliente(cliente);
    this.repository.persistir(cliente);
  }

  private void validarCliente(Cliente cliente) {
    //valida o cliente.
  }
}
