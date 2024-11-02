package io.github.danuser2018.picoauth.client.domain.services;

import java.security.KeyPair;

public interface CryptoService {
    KeyPair generateKeyPair();
}
