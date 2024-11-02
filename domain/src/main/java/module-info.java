module domain {
    requires static lombok;

    requires spring.context;

    exports io.github.danuser2018.picoauth.client.domain.models;
    exports io.github.danuser2018.picoauth.client.domain.ports.inbound;
    exports io.github.danuser2018.picoauth.client.domain.ports.outbound;

    exports io.github.danuser2018.picoauth.client.domain.config to spring.context;

    opens io.github.danuser2018.picoauth.client.domain.usecases to spring.core;
    opens io.github.danuser2018.picoauth.client.domain.services to spring.core;
    opens io.github.danuser2018.picoauth.client.domain.config to spring.core, spring.beans;
}