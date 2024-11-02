package io.github.danuser2018.picoauth.client;

import io.github.danuser2018.picoauth.client.domain.ports.inbound.StartAppPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
final class PicoAuthClientStartUpRunner implements ApplicationRunner {
    @NonNull
    private final StartAppPort startAppPort;

    @Override
    public void run(final ApplicationArguments args) {
        log.info("Starting app ...");
        startAppPort.startApp();
    }
}
