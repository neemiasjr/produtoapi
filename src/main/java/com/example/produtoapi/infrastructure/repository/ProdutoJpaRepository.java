package com.example.produtoapi.infrastructure.repository;

import com.example.produtoapi.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoJpaRepository extends JpaRepository<Produto, Long> {
}