package io.github.danuser2018.picoauth.client.domain.models;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.UUID;

@Value
@Builder
public class Identity {
    @NonNull UUID uuid;
    @NonNull PrivateKey privateKey;
    @NonNull PublicKey publicKey;
}
