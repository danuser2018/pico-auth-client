package io.github.danuser2018.picoauth.client.domain.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CryptoServiceImplTest {

    private static KeyPairGenerator generator;

    private final KeyPairGenerator keyPairGenerator = mock(KeyPairGenerator.class);
    private final CryptoServiceImpl cryptoService = new CryptoServiceImpl(keyPairGenerator);

    @BeforeAll
    static void beforeAll() throws NoSuchAlgorithmException {
        generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
    }

    @Test
    void testKeyPairGeneration() {

        var expected = generator.generateKeyPair();
        when(keyPairGenerator.generateKeyPair()).thenReturn(expected);

        var result = cryptoService.generateKeyPair();

        assertEquals(expected, result);
    }
}
