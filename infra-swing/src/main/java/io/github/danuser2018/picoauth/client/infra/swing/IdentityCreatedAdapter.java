package io.github.danuser2018.picoauth.client.infra.swing;

import io.github.danuser2018.picoauth.client.domain.models.Identity;
import io.github.danuser2018.picoauth.client.domain.ports.outbound.IdentityCreatedPort;
import io.github.danuser2018.picoauth.client.infra.swing.components.MainJFrame;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.swing.*;

import static java.lang.String.format;

@Slf4j
@Repository
@Conditional(NoHeadlessCondition.class)
final class IdentityCreatedAdapter implements IdentityCreatedPort {

    private MainJFrame mainJFrame;

    @Autowired
    public void setMainJFrame(@Lazy @NonNull final MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
    }

    @Override
    public void identityCreated(Identity identity) {
        log.info(format("Se ha creado la identidad %s", identity.getUuid()));
        SwingUtilities.invokeLater(
                () -> JOptionPane.showMessageDialog(
                        mainJFrame.getRootPane(), format("Se ha creado la identidad %s", identity.getUuid())
                )
        );
    }
}
