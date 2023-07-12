package com.alexsandro.domain.repository;

import com.alexsandro.domain.entity.Cliente;
import com.alexsandro.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

  List<Pedido> findByCliente(Cliente cliente);
}
