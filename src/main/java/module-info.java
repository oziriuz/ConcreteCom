module com.oziriuz.concretecom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.oziriuz.concretecom to javafx.fxml;
    exports com.oziriuz.concretecom;
    exports com.oziriuz.concretecom.controller;
    opens com.oziriuz.concretecom.controller to javafx.fxml;
    exports com.oziriuz.concretecom.model;
    opens com.oziriuz.concretecom.model to javafx.fxml;
}

