package com.alexsandro.rest.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Informacoes pedido dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacoesPedidoDto {
  private Integer id;
  private String clientName;
  private BigDecimal total;
  private String data;
  private List<InformacaoItemPedidoDto> items;
}
