package io.github.danuser2018.picoauth.client.domain.ports.outbound;

import io.github.danuser2018.picoauth.client.domain.models.Identity;

@FunctionalInterface
public interface IdentityCreatedPort {
    void identityCreated(Identity identity);
}
