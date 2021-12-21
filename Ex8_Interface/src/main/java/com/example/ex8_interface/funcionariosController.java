package com.example.ex8_interfacecadastro;

import listaEncadeada.Funcionario;
import listaEncadeada.Lista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class funcionariosController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML private Button btnHome;
    @FXML private Button btnNovoCadastro;
    @FXML private Button btnFuncionarios;
    @FXML private Button btnOrdenaCod;
    @FXML private Button btnOrdenaNome;
    @FXML private Button btnInfo;
    @FXML private Button btnExcluir;
    @FXML private Button btnLimpar;
    @FXML private Button btnSair;
    @FXML private TableView<Funcionario> table;
    @FXML private TableColumn<Funcionario, Integer> columnCodigo;
    @FXML private TableColumn<Funcionario, String> columnNome;
    @FXML private TableColumn<Funcionario, String> columnSalario;
    @FXML private TableColumn<Funcionario, String> columnAdmissao;
    @FXML private TableColumn<Funcionario, String> columnTempoEmpresa;

    private final Lista<Funcionario> listaFuncionarios = new Lista<Funcionario>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        criaTabela();
    }

    @FXML void btnHomeOn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bemVindo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML void btnNovoCadastroOn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("novoCadastro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML void btnSairOn(ActionEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void criaTabela(){
        columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codFuncionario"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnSalario.setCellValueFactory(new PropertyValueFactory<>("valorSalario"));
        columnAdmissao.setCellValueFactory(new PropertyValueFactory<>("dataAdmissao"));
        columnTempoEmpresa.setCellValueFactory(new PropertyValueFactory<>("tempodeEmpresa"));
        table.setItems(listaFuncionarios.listaObservable());
    }

    @FXML
    void btnOrdenaCodOn(ActionEvent event) throws IOException {
        listaFuncionarios.ordenaPorCodigo();
        criaTabela();
    }

    @FXML
    void btnOrdenaNomeOn(ActionEvent event) throws IOException {
        listaFuncionarios.ordenaPorNome();
        criaTabela();
    }

    @FXML
    void btnInfoOn(ActionEvent event) throws IOException {
        Alert info = new Alert(AlertType.INFORMATION);
        info.setTitle("+INFO");
        info.setHeaderText("Soma dos salários: R$ " +listaFuncionarios.somaSalarios()+ "\nMédia dos salários: R$ " +listaFuncionarios.mediaSalarios()+ "\nMaior salário: R$ " +listaFuncionarios.maiorSalario()+ "\nMenor salários: R$ " +listaFuncionarios.menorSalario());
        info.show();
    }

    @FXML
    void btnExcluirOn(ActionEvent event) throws IOException {
        listaFuncionarios.removePorCodigo(table.getSelectionModel().getSelectedItem().getCodFuncionario());
        criaTabela();
    }

    @FXML
    void btnLimparOn(ActionEvent event) throws IOException {
        listaFuncionarios.limpaLista();
        listaFuncionarios.salvaArquivo();
        criaTabela();
    }

}
