package io.github.danuser2018.picoauth.client.domain.services;

import io.github.danuser2018.picoauth.client.domain.ports.outbound.StartUIPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UIServiceImplTest {

    private UIServiceImpl uiServiceImpl;
    private final StartUIPort startUIPort = Mockito.mock();

    @BeforeEach
    void beforeTest() {
        uiServiceImpl = new UIServiceImpl(startUIPort);
    }

    @Test
    void testStartUI() {
        uiServiceImpl.startUI();
        Mockito.verify(startUIPort).startUI();
    }
}
