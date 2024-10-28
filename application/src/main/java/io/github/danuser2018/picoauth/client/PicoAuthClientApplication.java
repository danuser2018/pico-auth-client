package io.github.danuser2018.picoauth.client;

import io.github.danuser2018.picoauth.client.domain.services.UIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PicoAuthClientApplication {
    public static void main(String[] args) {
        final var context = SpringApplication.run(PicoAuthClientApplication.class, args);

        log.info("Starting user interface ...");
        final var uiService = context.getBean(UIService.class);
        uiService.startUI();
    }
}
