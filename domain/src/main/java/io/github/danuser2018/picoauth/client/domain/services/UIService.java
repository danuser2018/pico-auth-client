package io.github.danuser2018.picoauth.client.domain.services;

import io.github.danuser2018.picoauth.client.domain.ports.outbound.StartUIPort;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class UIService {
    private final StartUIPort startUIPort;

    public UIService(@NonNull final StartUIPort startUIPort) {
        this.startUIPort = startUIPort;
    }

    public void startUI() {
        startUIPort.startUI();
    }
}
