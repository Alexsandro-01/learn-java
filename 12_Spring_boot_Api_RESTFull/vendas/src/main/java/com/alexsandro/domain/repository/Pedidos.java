package com.alexsandro.domain.repository;

import com.alexsandro.domain.entity.Cliente;
import com.alexsandro.domain.entity.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Pedidos.
 */
public interface Pedidos extends JpaRepository<Pedido, Integer> {

  List<Pedido> findByCliente(Cliente cliente);
}
