module application {
    requires static lombok;
    requires org.slf4j;

    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.core;

    requires domain;

    opens io.github.danuser2018.picoauth.client;
}