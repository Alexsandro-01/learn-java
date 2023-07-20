package com.alexsandro.domain.service;

import com.alexsandro.domain.entity.Pedido;
import com.alexsandro.rest.controller.dto.PedidoDto;

public interface PedidoService {

  Pedido salvar(PedidoDto dto);
}
