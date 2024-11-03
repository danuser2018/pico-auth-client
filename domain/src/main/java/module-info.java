module domain {
    requires static lombok;

    requires spring.context;

    exports io.github.danuser2018.picoauth.client.domain.models;
    exports io.github.danuser2018.picoauth.client.domain.ports.inbound;
}