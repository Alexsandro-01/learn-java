package com.alexsandro.rest.controller;

import com.alexsandro.domain.entity.ItemPedido;
import com.alexsandro.domain.entity.Pedido;
import com.alexsandro.domain.enums.StatusPedido;
import com.alexsandro.domain.service.PedidoService;
import com.alexsandro.rest.controller.dto.AtualizarStatusPedidoDto;
import com.alexsandro.rest.controller.dto.InformacaoItemPedidoDto;
import com.alexsandro.rest.controller.dto.InformacoesPedidoDto;
import com.alexsandro.rest.controller.dto.PedidoDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
  public Integer save(@RequestBody @Valid PedidoDto dto) {
    Pedido pedido = service.salvar(dto);

    return pedido.getId();
  }

  /**
   * Get pedido by id.
   *
   * @param id the pedido's id
   * @return the pedido by id
   */
  @GetMapping("/{id}")
  public InformacoesPedidoDto getById(@PathVariable Integer id) {
    return service
        .obterPedidoCompleto(id)
        .map(pedido -> converter(pedido))
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado.")
        );
  }

  private InformacoesPedidoDto converter(Pedido pedido) {
    return InformacoesPedidoDto
        .builder()
        .id(pedido.getId())
        .data(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyy")))
        .clientName(pedido.getCliente().getNome())
        .total(pedido.getTotal())
        .status(pedido.getStatus().name())
        .items(converter(pedido.getItens()))
        .build();
  }

  private List<InformacaoItemPedidoDto> converter(Set<ItemPedido> itens) {
    if (CollectionUtils.isEmpty(itens)) {
      return Collections.emptyList();
    }

    return itens.stream()
        .map(itemPedido -> InformacaoItemPedidoDto
            .builder()
            .precoUnitario(itemPedido.getProduto().getPreco())
            .quantidade(itemPedido.getQuantidade())
            .build()
        )
        .collect(Collectors.toList());
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateStatus(
      @RequestBody AtualizarStatusPedidoDto dto,
      @PathVariable Integer id
  ) {
    String newStatus = dto.getNovoStatus();
    service.atualizaStatus(id, StatusPedido.valueOf(newStatus));
  }
}
