package io.github.danuser2018.picoauth.client.infra.swing;

import io.github.danuser2018.picoauth.client.domain.ports.outbound.StartUIPort;
import io.github.danuser2018.picoauth.client.infra.swing.components.MainJFrame;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.awt.*;

@Slf4j
@Repository
@Conditional(NoHeadlessUIAdapter.Condition.class)
@RequiredArgsConstructor
public class NoHeadlessUIAdapter implements StartUIPort {

    public static class Condition implements org.springframework.context.annotation.Condition {
        @Override
        public boolean matches(@NonNull final ConditionContext context, @NonNull final AnnotatedTypeMetadata metadata) {
            return !GraphicsEnvironment.isHeadless();
        }
    }

    @NonNull
    private final MainJFrame mainJFrame;

    @Override
    public void startUI() {
        SwingUtilities.invokeLater(() -> mainJFrame.setVisible(true));
    }
}
