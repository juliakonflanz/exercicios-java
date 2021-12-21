module com.example.ex8_interfacecadastro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ex8_interfacecadastro to javafx.fxml;
    exports com.example.ex8_interfacecadastro;
}
