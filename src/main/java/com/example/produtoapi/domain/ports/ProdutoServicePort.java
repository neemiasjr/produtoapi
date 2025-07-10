package com.example.produtoapi.domain.ports;

import com.example.produtoapi.domain.model.Produto;
import java.util.List;


public interface ProdutoServicePort {
    List<Produto> listar();
    Produto salvar(Produto produto);
    void remover(Long id);
}