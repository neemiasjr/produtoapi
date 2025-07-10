package com.example.produtoapi.infrastructure.service;

import com.example.produtoapi.domain.model.AppUser;
import com.example.produtoapi.infrastructure.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class SeedService {

    private final UserRepository userRepository;

    public SeedService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void executarSeed() {
        if (userRepository.count() == 0) {
            userRepository.save(new AppUser(null, "admin", "1234"));
            userRepository.save(new AppUser(null, "usuario", "1234"));
            log.info("✅ Seed executado manualmente");
        }
    }
}
