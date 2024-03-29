package com.alexsandro.rest.controller;

import com.alexsandro.domain.entity.Produto;
import com.alexsandro.domain.repository.Produtos;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * The type Produto controller.
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
  @Autowired
  private Produtos produtosRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Produto save(@RequestBody @Valid Produto produto) {
    return produtosRepository.save(produto);
  }

  /**
   * Find all Produtos.
   *
   * @param filtro produto to search
   * @return the list of produtos
   */
  @GetMapping
  public List<Produto> find(Produto filtro) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(
            ExampleMatcher.StringMatcher.CONTAINING
        );

    Example<Produto> example = Example.of(filtro, matcher);

    return produtosRepository.findAll(example);
  }

  /**
   * Find produto by id.
   *
   * @param id the produto id
   * @return the produto
   */
  @GetMapping("/{id}")
  public Produto findById(@PathVariable Integer id) {
    return produtosRepository
        .findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        );
  }

  /**
   * Update a produto.
   *
   * @param id      the produto id
   * @param produto the produto
   */
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(
      @PathVariable Integer id,
      @RequestBody @Valid Produto produto
  ) {
    produtosRepository.findById(id)
        .map((produtoExist) -> {
          produto.setId(id);
          produtosRepository.save(produto);

          return produtoExist;
        })
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe.")
        );
  }

  /**
   * Delete a produto.
   *
   * @param id the produto id
   */
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    produtosRepository.findById(id)
        .map((produto -> {
          produtosRepository.delete(produto);
          return produto;
        }))
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe")
        );
  }

}
