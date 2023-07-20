package com.alexsandro.domain.service.impl;

import com.alexsandro.domain.entity.Cliente;
import com.alexsandro.domain.entity.ItemPedido;
import com.alexsandro.domain.entity.Pedido;
import com.alexsandro.domain.entity.Produto;
import com.alexsandro.domain.exception.RegraNegocioException;
import com.alexsandro.domain.repository.Clientes;
import com.alexsandro.domain.repository.ItensPedido;
import com.alexsandro.domain.repository.Pedidos;
import com.alexsandro.domain.repository.Produtos;
import com.alexsandro.domain.service.PedidoService;
import com.alexsandro.rest.controller.dto.ItemPedidoDto;
import com.alexsandro.rest.controller.dto.PedidoDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Pedidos service.
 */
@Service
public class PedidosServiceImpl implements PedidoService {

  private Pedidos pedidosRepository;
  private Clientes clientesRepository;
  private Produtos produtosRepository;
  private ItensPedido itensPedidoRepository;

  /**
   * Instantiates a new Pedidos service.
   *
   * @param pedidosRepository  the pedidos repository
   * @param clientesRepository the clientes repository
   * @param produtosRepository the produtos repository
   */
  public PedidosServiceImpl(
      Pedidos pedidosRepository,
      Clientes clientesRepository,
      Produtos produtosRepository,
      ItensPedido itensPedidoRepository
  ) {
    this.pedidosRepository = pedidosRepository;
    this.clientesRepository = clientesRepository;
    this.produtosRepository = produtosRepository;
    this.itensPedidoRepository = itensPedidoRepository;
  }

  /**
   * Metode for save a pedido.
   *
   * @param dto data transfer object
   * @return the pedido
   */
  @Override
  @Transactional // Como teremos muitas operações com o BD, essa anotation garante um rolback caso alguma das transações dê errado.
  public Pedido salvar(PedidoDto dto) {
    Integer idCliente = dto.getCliente();
    Cliente cliente = clientesRepository
        .findById(idCliente)
        .orElseThrow(
            () -> new RegraNegocioException("Código de cliente inválido.")
        );

    Pedido pedido = new Pedido();
    pedido.setTotal(dto.getTotal());
    pedido.setDataPedido(LocalDate.now());
    pedido.setCliente(cliente);

    List<ItemPedido> itemPedidos = converterItems(pedido, dto.getItems());
    pedidosRepository.save(pedido);
    List<ItemPedido> newItems = itensPedidoRepository.saveAll(itemPedidos);

    Set<ItemPedido> itemPedidoSet = new HashSet<>(newItems);
    pedido.setItens(itemPedidoSet);

    return pedido;
  }

  private List<ItemPedido> converterItems(
      Pedido pedido,
      List<ItemPedidoDto> items
  ) {
    if (items.isEmpty()) {
      throw new RegraNegocioException("Não é possível realizar pedido sem itens.");
    }

    return items
        .stream()
        .map(dto -> {
          Integer idProduto = dto.getProduto();
          Produto produto = produtosRepository
              .findById(idProduto)
              .orElseThrow(
                  () -> new RegraNegocioException(
                      "Código de produto inválido " + idProduto
                  )
              );

          ItemPedido itemPedido = new ItemPedido();
          itemPedido.setQuantidade(dto.getQuantidade());
          itemPedido.setPedido(pedido);
          itemPedido.setProduto(produto);

          return itemPedido;
        })
        .collect(Collectors.toList());
  }

}
