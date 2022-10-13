module com.example.e_commerce_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.e_commerce_app to javafx.fxml;
    exports com.example.e_commerce_app;
}