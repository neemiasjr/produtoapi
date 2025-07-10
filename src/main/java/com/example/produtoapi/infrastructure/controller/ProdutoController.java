package com.example.produtoapi.infrastructure.controller;

import com.example.produtoapi.application.service.ProdutoServiceImpl;
import com.example.produtoapi.domain.model.Produto;
import com.example.produtoapi.domain.ports.ProdutoServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoServicePort service;

    public ProdutoController(ProdutoServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.remover(id);
    }
}