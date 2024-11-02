module infra.swing {
    requires static lombok;
    requires org.slf4j;

    requires spring.beans;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.core;

    requires java.desktop;

    requires com.formdev.flatlaf;
    requires jiconfont;
    requires jiconfont.font.awesome;
    requires jiconfont.swing;

    requires domain;
}