package io.github.danuser2018.picoauth.client.domain.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

@Service
@RequiredArgsConstructor
final class CryptoServiceImpl implements CryptoService {

    @NonNull
    private final KeyPairGenerator keyPairGenerator;

    @Override
    public KeyPair generateKeyPair() {
        return keyPairGenerator.generateKeyPair();
    }
}
