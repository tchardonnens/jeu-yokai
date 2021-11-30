module com.example.yokai {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.example.yokai to javafx.fxml;
    exports com.example.yokai;
}