package io.github.danuser2018.picoauth.client.infra.swing.components;

import io.github.danuser2018.picoauth.client.domain.ports.inbound.AddNewIdentityPort;
import io.github.danuser2018.picoauth.client.infra.swing.NoHeadlessCondition;
import jiconfont.icons.font_awesome.FontAwesome;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CompletableFuture;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.lightGray;
import static java.awt.FlowLayout.RIGHT;
import static javax.swing.BorderFactory.createEmptyBorder;
import static jiconfont.swing.IconFontSwing.buildIcon;
import static jiconfont.swing.IconFontSwing.buildImage;

@Component
@Conditional(NoHeadlessCondition.class)
public class MainJFrame extends JFrame {

    @NonNull
    private final AddNewIdentityPort addNewIdentityPort;

    private JButton newIdentityButton;

    public MainJFrame(
            @Value("${user-interface.main-frame.width:800}") final int width,
            @Value("${user-interface.main-frame.height:600}") final int height,
            @NonNull AddNewIdentityPort addNewIdentityPort
    ) {
        super("PicoAuth - Client");

        this.addNewIdentityPort = addNewIdentityPort;

        setIconImage(buildImage(FontAwesome.KEY, 16, lightGray));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);

        createGUI();
        composeGUI();
    }

    private void createGUI() {
        newIdentityButton = new JButton(buildIcon(FontAwesome.PLUS, 32, lightGray));
        newIdentityButton.setToolTipText("Crea una nueva identidad");
        newIdentityButton.setBorder(createEmptyBorder(10, 40, 10, 40));
        newIdentityButton.addActionListener(event -> addNewIdentity());
    }

    private void composeGUI() {
        setLayout(new BorderLayout());

        var identitiesPanel = Box.createGlue();

        var actionsPanel = new JPanel(new FlowLayout(RIGHT));
        actionsPanel.setBorder(createEmptyBorder(0, 20, 20, 20));
        actionsPanel.add(newIdentityButton);

        add(identitiesPanel, CENTER);
        add(actionsPanel, SOUTH);
    }

    private void addNewIdentity() {
        CompletableFuture.runAsync(addNewIdentityPort::addNewIdentity);
    }
}
