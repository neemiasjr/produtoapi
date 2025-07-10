package com.example.produtoapi.domain.ports;

import com.example.produtoapi.domain.model.Produto;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {
    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    Produto save(Produto produto);
    void delete(Long id);
}