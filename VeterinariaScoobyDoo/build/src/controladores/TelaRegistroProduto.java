/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAO.DAOProduto;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.VeterinariaScoobyDoo;

/**
 * FXML Controller class
 *
 * @author Cliente
 */
public class TelaRegistroProduto implements Initializable {

    @FXML
    private Button Cadastrar;
    @FXML
    private Button Voltar;
    @FXML
    private TextField lblNomeProduto;
    @FXML
    private TextField lblValorProduto;
    @FXML
    private TextArea lblDescricao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onClickCadastrar(ActionEvent event) {
        Produto produto = new Produto();
        produto.setNome(lblNomeProduto.getText());
        produto.setValor(Double.valueOf(lblValorProduto.getText()));
        produto.setDescricao(lblDescricao.getText());
        DAOProduto dao = new DAOProduto();
        dao.salvar(produto);
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
