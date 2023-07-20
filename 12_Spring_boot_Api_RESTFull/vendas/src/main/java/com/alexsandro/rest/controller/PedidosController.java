package com.alexsandro.rest.controller;

import com.alexsandro.domain.entity.Pedido;
import com.alexsandro.domain.service.PedidoService;
import com.alexsandro.rest.controller.dto.PedidoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * The type Pedidos controller.
 */
@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

  private final PedidoService service;

  public PedidosController(PedidoService service) {
    this.service = service;
  }

  /**
   * Save a new pedido on DB.
   *
   * @param dto the dto's pedido
   * @return the pedido's id
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Integer save(@RequestBody PedidoDto dto) {
    Pedido pedido = service.salvar(dto);

    return pedido.getId();
  }
}
