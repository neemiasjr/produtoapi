package com.example.produtoapi.application.service;

import com.example.produtoapi.domain.model.Produto;
import com.example.produtoapi.domain.ports.ProdutoRepositoryPort;
import com.example.produtoapi.domain.ports.ProdutoServicePort;
import com.example.produtoapi.infrastructure.messaging.KafkaProdutoConsumer;
import com.example.produtoapi.infrastructure.messaging.KafkaProdutoProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProdutoServiceImpl implements ProdutoServicePort {

    private final ProdutoRepositoryPort repository;
    private final KafkaProdutoProducer kafkaProdutoProducer;

    public ProdutoServiceImpl(ProdutoRepositoryPort repository, KafkaProdutoProducer kafkaProdutoProducer) {
        this.kafkaProdutoProducer = kafkaProdutoProducer;
        this.repository = repository;
    }

    @Override
    public List<Produto> listar() {
        return repository.findAll();
    }

    @Override
    public Produto salvar(Produto produto) {
        Produto salvo = repository.save(produto);
        log.info("Produto salvo: {}", salvo);
        this.kafkaProdutoProducer.enviarProdutoCriado(produto);
        return  salvo;
    }

    @KafkaListener(topics = "produtos-criados", groupId = "produto-group", containerFactory = "kafkaListenerContainerFactory")
    public String consumir() {
        return "Consumindo mensagem do Kafka";
    }

    @Override
    public void remover(Long id) {
        repository.delete(id);
    }
}