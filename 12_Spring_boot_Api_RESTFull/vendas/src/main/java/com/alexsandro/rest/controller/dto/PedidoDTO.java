package com.alexsandro.rest.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Item pedido dto.
 */
@Getter
@Setter
public class PedidoDto {
  private int cliente;
  private BigDecimal total;
  private List<ItemPedidoDto> items;
}
