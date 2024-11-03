package io.github.danuser2018.picoauth.client.infra.swing.components;

import io.github.danuser2018.picoauth.client.domain.models.Identity;
import io.github.danuser2018.picoauth.client.domain.ports.inbound.NewIdentityPort;
import jiconfont.icons.font_awesome.FontAwesome;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.lightGray;
import static java.awt.FlowLayout.RIGHT;
import static java.lang.String.format;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.JOptionPane.showMessageDialog;
import static jiconfont.swing.IconFontSwing.buildIcon;
import static jiconfont.swing.IconFontSwing.buildImage;

@Slf4j
public final class MainJFrame extends JFrame {

    @NonNull
    private final NewIdentityPort newIdentityPort;

    private JButton newIdentityButton;

    public MainJFrame(final int width, final int height, final @NonNull NewIdentityPort newIdentityPort) {
        super("PicoAuth - Client");

        this.newIdentityPort = newIdentityPort;

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
        newIdentityPort.addNewIdentity()
                .whenComplete(
                        (identity, ex) -> {
                            if (identity != null) {
                                identityAdded(identity);
                            } else {
                                identityAddedFailed(ex);
                            }
                        }
                );
    }

    private void identityAdded(Identity identity) {
        log.info(format("Se ha añadido una nueva identidad: %s", identity.getUuid()));
        SwingUtilities.invokeLater(() -> showMessageDialog(
                        getRootPane(), format("Se ha creado la identidad %s", identity.getUuid())
                )
        );
    }

    private void identityAddedFailed(Throwable ex) {
        log.error(format("Se ha producido un error creando una nueva identidad: %s %s",
                ex.getClass(), ex.getMessage()), ex);

        SwingUtilities.invokeLater(() -> showMessageDialog(
                        getRootPane(),
                        "Se ha producido un error creando la nueva identidad. Inténtelo más tarde"
                )
        );
    }
}
