package com.example.produtoapi.infrastructure.messaging;

import com.example.produtoapi.domain.model.Produto;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaProdutoConsumer {
    @KafkaListener(topics = "produtos-criados", groupId = "produto-group")
    public void consumir(Produto produto) {
        System.out.println("Mensagem recebida: " + produto.toString());
    }
}
