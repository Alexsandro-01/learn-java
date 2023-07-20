package com.alexsandro.rest.controller.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Pedido dto.
 */
@Getter
@Setter
public class ItemPedidoDto {
  private int produto;
  private int quantidade;
}
