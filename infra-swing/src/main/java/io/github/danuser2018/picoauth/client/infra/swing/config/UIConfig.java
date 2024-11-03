package io.github.danuser2018.picoauth.client.infra.swing.config;

import com.formdev.flatlaf.FlatDarkLaf;
import io.github.danuser2018.picoauth.client.domain.ports.inbound.NewIdentityPort;
import io.github.danuser2018.picoauth.client.infra.swing.NoHeadlessCondition;
import io.github.danuser2018.picoauth.client.infra.swing.components.MainJFrame;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
@Conditional(NoHeadlessCondition.class)
public class UIConfig {

    @Value("${user-interface.main-frame.width:800}")
    private int width;

    @Value("${user-interface.main-frame.height:600}")
    private int height;

    public UIConfig() {
        FlatDarkLaf.setup();
        IconFontSwing.register(FontAwesome.getIconFont());
    }

    @Bean
    public JFrame mainJFrame(@NonNull NewIdentityPort newIdentityPort) {
        return new MainJFrame(width, height, newIdentityPort);
    }
}
