package io.github.danuser2018.picoauth.client.infra.swing.components;

import io.github.danuser2018.picoauth.client.infra.swing.NoHeadlessUIAdapter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@ConditionalOnBean(NoHeadlessUIAdapter.class)
public class MainJFrame extends JFrame {

    private final static String TITLE = "PicoAuth - Client";

    public MainJFrame(@Value("${user-interface.main-frame.width:800}") final int width,
                      @Value("${user-interface.main-frame.height:600}") final int height,
                      @NonNull final ImageIcon logoIcon
    ) {
        super(TITLE);

        setIconImage(logoIcon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
    }
}
