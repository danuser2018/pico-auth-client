package io.github.danuser2018.picoauth.client.domain.usecases;

import io.github.danuser2018.picoauth.client.domain.services.UIService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StartAppUseCaseTest {

    private final UIService uiService = Mockito.mock(UIService.class);
    private final StartAppUseCase startAppUseCase = new StartAppUseCase(uiService);

    @Test
    void testStartApp() {
        startAppUseCase.startApp();
        Mockito.verify(uiService).startUI();
    }
}
