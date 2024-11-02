package io.github.danuser2018.picoauth.client.domain.usecases;

import io.github.danuser2018.picoauth.client.domain.models.Identity;
import io.github.danuser2018.picoauth.client.domain.ports.outbound.IdentityCreatedPort;
import io.github.danuser2018.picoauth.client.domain.services.CryptoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class AddNewIdentityUseCaseTest {

    private static KeyPairGenerator generator;

    private final UUID uuid = UUID.randomUUID();
    private final CryptoService cryptoService = Mockito.mock(CryptoService.class);
    private final IdentityCreatedPort identityCreatedPort = Mockito.mock(IdentityCreatedPort.class);

    private final AddNewIdentityUseCase addNewIdentityUseCase =
            new AddNewIdentityUseCase(() -> uuid, cryptoService, identityCreatedPort);

    @BeforeAll
    static void beforeAll() throws NoSuchAlgorithmException {
        generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
    }

    @Test
    void testAddNewIdentity() {
        var keyPair = generator.generateKeyPair();

        Mockito.when(cryptoService.generateKeyPair()).thenReturn(keyPair);
        var expected = Identity.builder()
                .uuid(uuid)
                .publicKey(keyPair.getPublic())
                .privateKey(keyPair.getPrivate())
                .build();

        addNewIdentityUseCase.addNewIdentity();
        Mockito.verify(identityCreatedPort).identityCreated(expected);
    }
}
