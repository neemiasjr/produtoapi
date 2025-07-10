package com.example.produtoapi.infrastructure.repository;

import com.example.produtoapi.domain.model.Produto;
import com.example.produtoapi.domain.ports.ProdutoRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private final ProdutoJpaRepository jpaRepository;

    public ProdutoRepositoryAdapter(ProdutoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Produto> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Produto save(Produto produto) {
        return jpaRepository.save(produto);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}