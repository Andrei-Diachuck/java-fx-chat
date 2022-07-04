module com.example.javafxchat {
    requires javafx.controls;
    requires javafx.fxml;
    
    
    exports com.example.javafxchat.client;
    opens com.example.javafxchat.client to javafx.fxml;
}