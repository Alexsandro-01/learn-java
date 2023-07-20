package com.alexsandro.rest.controller.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Informacao item pedido dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacaoItemPedidoDto {
  private String descricaoProduto;
  private BigDecimal precoUnitario;
  private Integer quantidade;
}
