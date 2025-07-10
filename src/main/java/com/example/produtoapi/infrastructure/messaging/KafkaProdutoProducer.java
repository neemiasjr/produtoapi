package com.example.produtoapi.infrastructure.messaging;

import com.example.produtoapi.domain.model.Produto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProdutoProducer {

    private final KafkaTemplate<String, Produto> kafkaTemplate;

    public KafkaProdutoProducer(KafkaTemplate<String, Produto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarProdutoCriado(Produto produto) {
        kafkaTemplate.send("produtos-criados", produto);
    }
}