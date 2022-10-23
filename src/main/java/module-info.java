module com.oziriuz.concretecom {
    requires java.sql;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.persistence;

    opens com.oziriuz.concretecom to javafx.fxml;
    exports com.oziriuz.concretecom;
    exports com.oziriuz.concretecom.controller;
    opens com.oziriuz.concretecom.controller to javafx.fxml;
    exports com.oziriuz.concretecom.model;
    opens com.oziriuz.concretecom.model to javafx.fxml;
}

