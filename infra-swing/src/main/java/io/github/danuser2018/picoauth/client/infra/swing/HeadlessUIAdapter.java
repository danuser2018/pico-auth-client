package io.github.danuser2018.picoauth.client.infra.swing;

import io.github.danuser2018.picoauth.client.domain.ports.outbound.StartUIPort;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Slf4j
@Repository
@Conditional(HeadlessUIAdapter.Condition.class)
public class HeadlessUIAdapter implements StartUIPort {

    public static class Condition implements org.springframework.context.annotation.Condition {
        @Override
        public boolean matches(@NonNull final ConditionContext context, @NonNull final AnnotatedTypeMetadata metadata) {
            return GraphicsEnvironment.isHeadless();
        }
    }

    @Override
    public void startUI() {
        log.warn("Headless mode is activated. Cannot display user interface !!!");
        log.warn("Consider add '-Djava.awt.headless=false' to your execution command to disable headless mode");
    }
}
