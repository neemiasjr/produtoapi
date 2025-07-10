package com.example.produtoapi.infrastructure.controller;

import com.example.produtoapi.infrastructure.service.SeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seed")
public class SeedController {

    private final SeedService seedService;

    public SeedController(SeedService seedService) {
        this.seedService = seedService;
    }

    @PostMapping("/executar")
    public ResponseEntity<String> executar() {
        seedService.executarSeed();
        return ResponseEntity.ok("Seed executado manualmente");
    }
}