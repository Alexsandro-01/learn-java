package com.alexsandro.rest.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import com.alexsandro.validation.NotEmptyList;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Item pedido dto.
 */
@Getter
@Setter
public class PedidoDto {

  @NotNull(message = "Informe o id do cliente.")
  private Integer cliente;

  @NotNull(message = "Campo total do pedido é obrigatório.")
  private BigDecimal total;

  @NotEmptyList(message = "Pedido não pode ser realizado sem itens.")
  private List<ItemPedidoDto> items;
}
