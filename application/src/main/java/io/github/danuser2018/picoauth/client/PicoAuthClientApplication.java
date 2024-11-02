package io.github.danuser2018.picoauth.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PicoAuthClientApplication {
    public static void main(final String[] args) {
        SpringApplication.run(PicoAuthClientApplication.class, args);
    }
}
