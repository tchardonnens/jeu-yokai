module com.example.yokai {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;

    opens com.example.yokai to javafx.fxml;
    exports com.example.yokai;
    exports com.example.yokai.controllers;
    opens com.example.yokai.controllers to javafx.fxml;
    exports com.example.yokai.rules;
    opens com.example.yokai.rules to javafx.fxml;
}