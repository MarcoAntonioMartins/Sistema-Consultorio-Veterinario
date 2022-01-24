/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAO.DAODono;
import entidades.Dono;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.VeterinariaScoobyDoo;

/**
 * FXML Controller class
 *
 * @author Cliente
 */
public class TelaCadastroClientes implements Initializable {

    @FXML
    private Button Cadastrar;
    @FXML
    private Button Voltar;
    @FXML
    private TextField lblNome;
    @FXML
    private TextField lblRg;
    @FXML
    private TextField lblCpf;
    @FXML
    private TextField lblEndereco;
    @FXML
    private TextField lblTelefone;
    @FXML
    private TextField lblCelular;
    @FXML
    private TextField lblEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onClickCadastrar(ActionEvent event) {
        Dono Dono = new Dono();
        Dono.setNome(lblNome.getText());
        Dono.setRg(lblRg.getText());
        Dono.setTelefone(lblTelefone.getText());
        Dono.setCpf(lblCpf.getText());
        Dono.setEmail(lblEmail.getText());
        Dono.setEndereco(lblEndereco.getText());
        Dono.setCelular(lblCelular.getText());
        DAODono dao = new DAODono();
        dao.salvar(Dono);
    }

    @FXML
    private void onClickVoltar(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/Tela_Main.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (IOException e) {
            System.out.println("ERRO AO ABRIR TELA CADASTRO");
        }
    }

}
