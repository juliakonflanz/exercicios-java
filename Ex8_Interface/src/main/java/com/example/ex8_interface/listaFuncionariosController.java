package com.example.ex8_interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class listaFuncionariosController {

    private Stage stage;
    private Scene scene;

    @FXML private Button BtnSair;
    @FXML private Pane paneiCad;
    @FXML private Button btniCad;
    @FXML private ChoiceBox<?> boxEscolheDado;
    @FXML private Button btnBuscar;
    @FXML private Button btnFuncionarios;
    @FXML private Button btnNovoCadastro;
    @FXML private Button btnOrdenaCodigo;
    @FXML private Button btnOrdenaNome;
    @FXML private GridPane gridFuncionarios;
    @FXML private HBox hboxBuscaFuncionario;
    @FXML private Pane paneFuncionarios;
    @FXML private TableView<?> tableDados;
    @FXML private VBox vboxMenu;

    @FXML
    void btniCadOnAction (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bemVindo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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

    @FXML
    void btnBuscarOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrdenaCodigoOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrdenaNomeOnAction(ActionEvent event) {

    }

}
