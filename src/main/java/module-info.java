module com.oziriuz.concretecom {
    requires java.sql;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports com.oziriuz.concretecom;
    exports com.oziriuz.concretecom.controller;
    opens com.oziriuz.concretecom.controller;
}
