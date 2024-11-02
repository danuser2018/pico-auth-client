package io.github.danuser2018.picoauth.client.domain.ports.inbound;

import io.github.danuser2018.picoauth.client.domain.models.Identity;

@FunctionalInterface
public interface AddNewIdentityPort {
    void addNewIdentity();
}
