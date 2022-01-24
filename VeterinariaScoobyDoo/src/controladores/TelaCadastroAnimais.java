/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAO.DAO;
import DAO.DAOAnimal;
import entidades.Animal;
import entidades.Dono;
import entidades.Produto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.VeterinariaScoobyDoo;

/**
 * FXML Controller class
 *
 * @author Cliente
 */
public class TelaCadastroAnimais implements Initializable {

    @FXML
    private Button Cadastrar;
    @FXML
    private Button Voltar;
    @FXML
    private TextField lblNome;
    @FXML
    private TextField lblRaca;
    @FXML
    private TextField lblIdade;
    @FXML
    private TextField lblCpfDono;
    @FXML
    private ComboBox cbEspecie;
    @FXML
    private ComboBox<Dono> cbDono;

    private ObservableList<Dono> listaDono;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DAO dao = new DAO();
        cbEspecie.getItems().add("Cachorro");
        cbEspecie.getItems().add("Gato");
        cbEspecie.setValue("Selecione um Produto");

        listaDono = dao.consultarObservableList(Dono.class);
        cbDono.setItems(listaDono);

    }

    @FXML
    private void onClickCadastrar(ActionEvent event) {
        Animal Animal = new Animal();
        Animal.setNome(lblNome.getText());
        Animal.setRaca(lblRaca.getText());
        Animal.setTipo(cbEspecie.getSelectionModel().getSelectedItem().toString());
        Animal.setIdade(Integer.valueOf(lblIdade.getText()));
        Animal.setDono(cbDono.getSelectionModel().getSelectedItem());
        DAOAnimal dao = new DAOAnimal();
        dao.salvar(Animal);
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
