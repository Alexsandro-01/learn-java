package com.alexsandro.domain.repository;

import com.alexsandro.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Produtos.
 */
public interface Produtos extends JpaRepository<Produto, Integer> {
}
