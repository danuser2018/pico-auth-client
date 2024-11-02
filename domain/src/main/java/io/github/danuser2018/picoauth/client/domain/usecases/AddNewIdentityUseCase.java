package io.github.danuser2018.picoauth.client.domain.usecases;

import io.github.danuser2018.picoauth.client.domain.models.Identity;
import io.github.danuser2018.picoauth.client.domain.ports.inbound.AddNewIdentityPort;
import io.github.danuser2018.picoauth.client.domain.ports.outbound.IdentityCreatedPort;
import io.github.danuser2018.picoauth.client.domain.services.CryptoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.UUID;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
final class AddNewIdentityUseCase implements AddNewIdentityPort {

    @NonNull
    private final Supplier<UUID> uuidSupplier;

    @NonNull
    private final CryptoService cryptoService;

    @NonNull
    private final IdentityCreatedPort identityCreatedPort;

    @Override
    public void addNewIdentity() {
        final KeyPair keyPair = cryptoService.generateKeyPair();

        final var identity = Identity.builder()
                .uuid(uuidSupplier.get())
                .privateKey(keyPair.getPrivate())
                .publicKey(keyPair.getPublic())
                .build();

        identityCreatedPort.identityCreated(identity);
    }
}
