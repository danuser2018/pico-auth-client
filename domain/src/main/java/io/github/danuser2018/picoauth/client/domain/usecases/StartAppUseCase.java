package io.github.danuser2018.picoauth.client.domain.usecases;

import io.github.danuser2018.picoauth.client.domain.ports.inbound.StartAppPort;
import io.github.danuser2018.picoauth.client.domain.services.UIService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
final class StartAppUseCase implements StartAppPort {

    @NonNull
    private final UIService uiService;

    @Override
    public void startApp() {
        uiService.startUI();
    }
}
