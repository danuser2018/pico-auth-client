package io.github.danuser2018.picoauth.client.domain.ports.inbound;

import io.github.danuser2018.picoauth.client.domain.models.Identity;

import java.util.concurrent.CompletableFuture;

@FunctionalInterface
public interface NewIdentityPort {
    CompletableFuture<Identity> addNewIdentity();
}
