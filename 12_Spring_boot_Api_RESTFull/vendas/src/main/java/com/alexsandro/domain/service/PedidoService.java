package com.alexsandro.domain.service;

import com.alexsandro.domain.entity.Pedido;
import com.alexsandro.domain.enums.StatusPedido;
import com.alexsandro.rest.controller.dto.PedidoDto;
import java.util.Optional;

/**
 * The interface Pedido service.
 */
public interface PedidoService {

  Pedido salvar(PedidoDto dto);

  Optional<Pedido> obterPedidoCompleto(Integer id);

  void atualizaStatus(Integer id, StatusPedido status);
}
