package io.github.danuser2018.picoauth.client.domain.usecases;

import io.github.danuser2018.picoauth.client.domain.models.Identity;
import io.github.danuser2018.picoauth.client.domain.ports.inbound.NewIdentityPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
final class NewIdentityUseCase implements NewIdentityPort {

    @NonNull
    private final Supplier<UUID> uuidSupplier;

    @NonNull
    private final Supplier<KeyPair> keyPairSupplier;

    @Override
    public CompletableFuture<Identity> addNewIdentity() {
        return CompletableFuture.supplyAsync(this::createIdentity);
    }

    private Identity createIdentity() {
        final UUID uuid = uuidSupplier.get();
        final KeyPair keyPair = keyPairSupplier.get();

        return Identity.builder()
                .uuid(uuid)
                .privateKey(keyPair.getPrivate())
                .publicKey(keyPair.getPublic())
                .build();
    }
}
