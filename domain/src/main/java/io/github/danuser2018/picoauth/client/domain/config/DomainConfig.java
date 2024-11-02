package io.github.danuser2018.picoauth.client.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.function.Supplier;

@Configuration
public class DomainConfig {
    @Bean
    KeyPairGenerator keyPairGenerator() throws NoSuchAlgorithmException {
        var generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator;
    }

    @Bean
    Supplier<UUID> uuidSupplier() {
        return UUID::randomUUID;
    }
}
