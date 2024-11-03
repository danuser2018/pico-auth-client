package io.github.danuser2018.picoauth.client.infra.swing;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Slf4j
@Component
@RequiredArgsConstructor
@Conditional(NoHeadlessCondition.class)
final class UIStartUpRunner implements ApplicationRunner {

    @NonNull
    private final JFrame jFrame;

    @Override
    public void run(final ApplicationArguments args) {
        log.info("Starting UI ...");
        SwingUtilities.invokeLater(() -> jFrame.setVisible(true));
    }
}
