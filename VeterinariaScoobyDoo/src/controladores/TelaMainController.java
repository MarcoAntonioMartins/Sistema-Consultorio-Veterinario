package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import main.VeterinariaScoobyDoo;
import static relatorios.Gerador.geraRelatorioAnimais;
import static relatorios.Gerador.geraRelatorioClientes;
import static relatorios.Gerador.geraRelatorioConsulta;
import static relatorios.Gerador.geraRelatorioConsultas;
import static relatorios.Gerador.geraRelatorioFuncionarios;
import static relatorios.Gerador.geraRelatorioProduto;

public class TelaMainController implements Initializable {

    @FXML
    private ComboBox comboRelatorio;
    List<String> list = new ArrayList<String>();
    private ObservableList<String> listaRelatorio = FXCollections.observableList(list);
    @FXML
    private Button Cadastro_De_Funcionarios;
    @FXML
    private Button Registrar_Consulta;
    @FXML
    private Button Cadastro_De_Animais;
    @FXML
    private Button Cadastro_De_Produtos;
    @FXML
    private Button Cadastro_De_Clientes;
    @FXML
    private Button btnRelatorioData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaRelatorio.add("Animais");
        listaRelatorio.add("Produtos");
        listaRelatorio.add("Clientes");
        listaRelatorio.add("Funcionarios");
        listaRelatorio.add("Consultas");
        comboRelatorio.setItems(listaRelatorio);
        comboRelatorio.setValue("Relatorio");

    }

    @FXML
    public void onClickCadastro_De_Clientes() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/Cadastro_De_Cliente.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (IOException e) {
            System.out.println("ERRO AO ABRIR TELA CADASTRO");
        }
    }

    @FXML
    private void onClickRetirar_Senha(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/Retirada_Da_senha.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (IOException e) {
            System.out.println("ERRO AO ABRIR TELA DE RETIRADA DE SENHA");
        }
    }

    @FXML
    private void onClickCadastro_De_Funcionarios(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/Tela_Funcionarios.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (IOException e) {
            System.out.println("ERRO AO ABRIR TELA CADASTRO");
        }
    }

    @FXML
    private void Registrar_Consulta(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/Consulta.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (IOException e) {
            System.out.println("ERRO AO ABRIR TELA CONSULTA");
            e.printStackTrace();
        }
    }

    @FXML
    private void Cadastro_De_Animais(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../telas/Cadastro_De_Animais.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (IOException e) {
            System.out.println("ERRO AO ABRIR TELA CADASTRO");
        }
    }

    @FXML
    private void onClickCadastro_De_Produtos(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../telas/Registro_De_Produto.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (IOException e) {
            System.out.println("ERRO AO ABRIR TELA CADASTRO");
        }
    }

    @FXML
    private void onClickbtnRelatorioData(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../telas/TelaRelatorioFinal.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (IOException e) {
            System.out.println("ERRO AO ABRIR TELA CADASTRO");
        }
    }

    @FXML
    private void onClickcomboRelatorio(ActionEvent event) {

        switch (comboRelatorio.getSelectionModel().getSelectedItem().toString()) {
            case "Produtos":
                geraRelatorioProduto();
                break;
            case "Animais":
                geraRelatorioAnimais();
                break;
            case "Clientes":
                geraRelatorioClientes();
                break;
            case "Consultas":
                geraRelatorioConsulta();
                break;
            case "Funcionarios":
                geraRelatorioFuncionarios();
                break;
            default:
                System.out.println("teste");
                break;
        }

    }
}
