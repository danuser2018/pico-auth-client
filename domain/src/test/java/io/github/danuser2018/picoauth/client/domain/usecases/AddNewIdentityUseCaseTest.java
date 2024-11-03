package io.github.danuser2018.picoauth.client.domain.usecases;

import io.github.danuser2018.picoauth.client.domain.models.Identity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNewIdentityUseCaseTest {

    private static KeyPairGenerator generator;

    private final UUID uuid = UUID.randomUUID();

    private KeyPair keyPair;

    private final NewIdentityUseCase addNewIdentityUseCase = new NewIdentityUseCase(() -> uuid, () -> keyPair);

    @BeforeAll
    static void beforeAll() throws NoSuchAlgorithmException {
        generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
    }

    @BeforeEach
    void beforeEach() {
        keyPair = generator.generateKeyPair();
    }

    @Test
    void testAddNewIdentity() throws ExecutionException, InterruptedException {

        var expected = Identity.builder()
                .uuid(uuid)
                .publicKey(keyPair.getPublic())
                .privateKey(keyPair.getPrivate())
                .build();

        var result = addNewIdentityUseCase.addNewIdentity().get();

        assertEquals(expected, result);
    }
}
