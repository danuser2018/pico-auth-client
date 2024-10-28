package io.github.danuser2018.picoauth.client.domain.services;

import io.github.danuser2018.picoauth.client.domain.ports.outbound.StartUIPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UIServiceTest {

    private UIService uiService;
    private final StartUIPort startUIPort = Mockito.mock();

    @BeforeEach
    void beforeTest() {
        uiService = new UIService(startUIPort);
    }

    @Test
    void testStartUI() {
        uiService.startUI();
        Mockito.verify(startUIPort).startUI();
    }
}
