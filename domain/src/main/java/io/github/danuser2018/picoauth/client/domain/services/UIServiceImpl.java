package io.github.danuser2018.picoauth.client.domain.services;

import io.github.danuser2018.picoauth.client.domain.ports.outbound.StartUIPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
final class UIServiceImpl implements UIService {
    @NonNull
    private final StartUIPort startUIPort;

    public void startUI() {
        startUIPort.startUI();
    }
}
