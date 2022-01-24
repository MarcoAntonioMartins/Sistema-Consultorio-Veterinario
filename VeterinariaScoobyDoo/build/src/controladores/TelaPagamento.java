/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAO.DAOConsulta;
import entidades.Consulta;
import entidades.Produto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import main.VeterinariaScoobyDoo;

/**
 * FXML Controller class
 *
 * @author Cliente
 */
public class TelaPagamento implements Initializable {

    @FXML
    private Button Concluido;
    @FXML
    private Button Voltar;
    @FXML
    private ComboBox cbFormaPagamento;
    @FXML
    private ListView<Produto> lvItensUsados;
    @FXML
    private TextField txtValor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void onClickConcluido(ActionEvent event) {
        /*Consulta = Exame */
        Consulta Consulta = new Consulta();

        DAOConsulta dao = new DAOConsulta();
        dao.salvar(Consulta);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/Tela_Main.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (Exception e) {
            System.out.println("ERRO AO ABRIR TELA MAIN");
        }

    }

    @FXML
    private void onClickVoltar(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/Tela_Main.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (Exception e) {
            System.out.println("ERRO AO ABRIR TELA MAIN");
        }
    }

}
