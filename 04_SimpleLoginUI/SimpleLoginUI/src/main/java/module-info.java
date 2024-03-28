module com.example.simpleloginui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simpleloginui to javafx.fxml;
    exports com.example.simpleloginui;

    opens com.example.simpleloginui.controller to javafx.fxml;
    exports com.example.simpleloginui.controller;
}