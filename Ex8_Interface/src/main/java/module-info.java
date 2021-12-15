module com.example.ex8_interface {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ex8_interface to javafx.fxml;
    exports com.example.ex8_interface;
}