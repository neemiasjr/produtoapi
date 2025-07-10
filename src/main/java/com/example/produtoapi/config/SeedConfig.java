package com.example.produtoapi.config;

import com.example.produtoapi.domain.model.AppUser;
import com.example.produtoapi.infrastructure.repository.UserRepository;
import com.example.produtoapi.infrastructure.service.SeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SeedConfig {

    @Bean
    CommandLineRunner init(SeedService seedService) {
        return args -> seedService.executarSeed();
    }
}
