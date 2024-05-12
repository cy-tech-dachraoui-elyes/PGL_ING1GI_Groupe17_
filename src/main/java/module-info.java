module org.example.projetgenielogiciel {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;
    requires java.net.http;
    requires java.sql;

    opens org.example.projetgenielogiciel to javafx.fxml;
    exports org.example.projetgenielogiciel;
}