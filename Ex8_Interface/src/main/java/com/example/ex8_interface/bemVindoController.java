package com.example.ex8_interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

public class bemVindoController {

    private Stage stage;
    private Scene scene;

    @FXML
    void btnFuncionariosOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("listaFuncionarios.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnNovoCadastroOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("novoCadastro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnSairOnAction(ActionEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

}
