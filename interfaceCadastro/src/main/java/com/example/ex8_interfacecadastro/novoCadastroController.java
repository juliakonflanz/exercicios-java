package com.example.ex8_interfacecadastro;

import listaEncadeada.Funcionario;
import listaEncadeada.Lista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class novoCadastroController {

    private Stage stage;
    private Scene scene;

    @FXML private Button btnCadastrar;
    @FXML private Button btnFuncionarios;
    @FXML private Button btnHome;
    @FXML private Button btnNovoCadastro;
    @FXML private Button btnSair;
    @FXML private DatePicker dateDataAdmissao;
    @FXML private TextField txtCodFuncionario;
    @FXML private TextField txtNome;
    @FXML private TextField txtValorSalario;

    private final Lista<Funcionario> listaFuncionarios = new Lista<Funcionario>();

    @FXML void btnHomeOn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bemVindo.fxml"));
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

    @FXML private void btnCadastrarOn(javafx.event.ActionEvent actionEvent) throws IOException {
        int codFuncionario = Integer.parseInt(txtCodFuncionario.getText());
        String nome = txtNome.getText();
        String valorSalario = listaFuncionarios.trocaSalario(txtValorSalario.getText());
        String dataAdmissao = dateDataAdmissao.getValue().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        listaFuncionarios.insereNoFim(new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao));

        Alert cadastroOk = new Alert(AlertType.INFORMATION);
        cadastroOk.setTitle("Aviso");
        cadastroOk.setHeaderText("Funcionário cadastrado!");
        cadastroOk.show();

        limpaCampos();
        listaFuncionarios.salvaArquivo();
    }

    public void limpaCampos(){
        txtCodFuncionario.clear();
        txtNome.clear();
        txtValorSalario.clear();
        dateDataAdmissao = null;
    }

}
