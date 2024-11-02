package io.github.danuser2018.picoauth.client.infra.swing;


import lombok.NonNull;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.awt.*;

public class NoHeadlessCondition implements org.springframework.context.annotation.Condition {
    @Override
    public boolean matches(@NonNull final ConditionContext context, @NonNull final AnnotatedTypeMetadata metadata) {
        return !GraphicsEnvironment.isHeadless();
    }
}
