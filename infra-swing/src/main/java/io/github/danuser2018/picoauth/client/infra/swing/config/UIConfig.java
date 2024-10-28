package io.github.danuser2018.picoauth.client.infra.swing.config;

import com.formdev.flatlaf.FlatDarkLaf;
import io.github.danuser2018.picoauth.client.infra.swing.NoHeadlessUIAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
@ConditionalOnBean(NoHeadlessUIAdapter.class)
public class UIConfig {

    private static final String BASE_PATH = "infra-swing/src/main/resources/";

    public UIConfig() {
        FlatDarkLaf.setup();
    }

    @Bean
    public ImageIcon logoIcon() {
        return new ImageIcon(BASE_PATH + "main.png");
    }
}
