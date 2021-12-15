package com.example.ex8_interface;

import algoritmos.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import static java.lang.Integer.parseInt;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class novoCadastroController {

    private Stage stage;
    private Scene scene;
    private final List<Funcionario> listaFuncionarios = new LinkedList<>();

    @FXML private TextField txtCodigo, txtNome, txtSalario;
    @FXML private DatePicker txtData;

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
    void btnSairOnAction(ActionEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void limpaTxt(){
        txtCodigo.clear();
        txtNome.clear();
        txtSalario.clear();
    }

    @FXML
    void btnCadastrarOnAction(ActionEvent event) {
        int codFuncionario = parseInt(txtCodigo.getText());
        String nome = txtNome.getText();
        String valorSalario = txtSalario.getText();
        LocalDate localDate = txtData.getValue();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataAdmissao = localDate.format(formatoData);

        Funcionario listaFuncionarios = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);

        limpaTxt();

        Alert cadastroSalvo = new Alert(AlertType.INFORMATION);
        cadastroSalvo.setTitle("AVISO");
        cadastroSalvo.setHeaderText("Cadastro completo!");
        cadastroSalvo.show();
    }

}
