package io.github.danuser2018.picoauth.client.infra.swing;

import com.formdev.flatlaf.FlatDarkLaf;
import io.github.danuser2018.picoauth.client.domain.ports.outbound.StartUIPort;
import io.github.danuser2018.picoauth.client.infra.swing.components.MainJFrame;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.awt.*;

@Slf4j
@Repository
@Conditional(NoHeadlessUIAdapter.Condition.class)
public class NoHeadlessUIAdapter implements StartUIPort {

    public static class Condition implements org.springframework.context.annotation.Condition {
        @Override
        public boolean matches(@NonNull final ConditionContext context, @NonNull final AnnotatedTypeMetadata metadata) {
            return !GraphicsEnvironment.isHeadless();
        }
    }

    private MainJFrame mainJFrame;

    public NoHeadlessUIAdapter() {
        FlatDarkLaf.setup();
        IconFontSwing.register(FontAwesome.getIconFont());
    }

    @Autowired
    public void setMainJFrame(@Lazy @NonNull final MainJFrame frame) {
        this.mainJFrame = frame;
    }

    @Override
    public void startUI() {
        SwingUtilities.invokeLater(() -> mainJFrame.setVisible(true));
    }
}
