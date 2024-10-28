package io.github.danuser2018.picoauth.client.domain.models;

import lombok.NonNull;
import lombok.Value;

import java.security.PrivateKey;
import java.security.PublicKey;

@Value
public class Identity {
    @NonNull String name;
    @NonNull PrivateKey privateKey;
    @NonNull PublicKey publicKey;
}
