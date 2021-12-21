package com.example.ex8_interfacecadastro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class bemVindoController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML private Button btnFuncionarios;
    @FXML private Button btnNovoCadastro;
    @FXML private Button btnSair;

    @FXML
    void initialize() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML void btnNovoCadastroOn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("novoCadastro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML void btnFuncionariosOn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("funcionarios.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML void btnSairOn(ActionEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

}
