package io.github.danuser2018.picoauth.client.infra.swing;

import com.formdev.flatlaf.FlatDarkLaf;
import io.github.danuser2018.picoauth.client.domain.ports.outbound.StartUIPort;
import io.github.danuser2018.picoauth.client.infra.swing.components.MainJFrame;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.awt.*;

@Repository
@Conditional(NoHeadlessCondition.class)
final class StartUIAdapter implements StartUIPort {
    private MainJFrame mainJFrame;

    public StartUIAdapter() {
        FlatDarkLaf.setup();
        IconFontSwing.register(FontAwesome.getIconFont());
    }

    @Autowired
    public void setMainJFrame(@Lazy @NonNull final MainJFrame jFrame) {
        this.mainJFrame = jFrame;
    }

    @Override
    public void startUI() {
        SwingUtilities.invokeLater(() -> mainJFrame.setVisible(true));
    }
}
