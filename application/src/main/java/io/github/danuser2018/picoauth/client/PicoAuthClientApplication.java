package io.github.danuser2018.picoauth.client;

import io.github.danuser2018.picoauth.client.domain.ports.inbound.StartAppPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PicoAuthClientApplication {
    public static void main(String[] args) {
        final var context = SpringApplication.run(PicoAuthClientApplication.class, args);

        log.info("Starting app ...");
        final var startAppPort = context.getBean(StartAppPort.class);
        startAppPort.startApp();
    }
}
