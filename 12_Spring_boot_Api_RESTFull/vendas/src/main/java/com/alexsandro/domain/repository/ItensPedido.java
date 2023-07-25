package com.alexsandro.domain.repository;

import com.alexsandro.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Itens pedido.
 */
public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
