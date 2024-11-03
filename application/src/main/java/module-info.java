module application {
    requires spring.boot;
    requires spring.boot.autoconfigure;

    opens io.github.danuser2018.picoauth.client;
}