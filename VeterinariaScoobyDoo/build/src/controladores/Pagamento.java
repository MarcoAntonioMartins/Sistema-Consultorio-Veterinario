package controladores;

import DAO.DAO;
import DAO.DAOConsulta;
import entidades.Animal;
import entidades.Consulta;
import entidades.Dono;
import entidades.ItemConsulta;
import entidades.Produto;
import entidades.Veterinario;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javax.swing.JOptionPane.showMessageDialog;
import main.VeterinariaScoobyDoo;

public class Pagamento implements Initializable {

    @FXML
    private Button btnFinalizar;
    @FXML
    private Button btnVoltar;
    @FXML
    private TableView<Consulta> table_view;
    @FXML
    private TableColumn<Consulta, String> dono_coluna;
    @FXML
    private TableColumn<Consulta, String> data_coluna;
    @FXML
    private TableColumn<Consulta, String> valor_coluna;
    @FXML
    private TableColumn<Consulta, String> animal_coluna;
    @FXML
    private TableColumn<Consulta, String> status_coluna;

    private ArrayList<Consulta> listaConsulta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DAO dao = new DAO();
        listaConsulta = new ArrayList<Consulta>(dao.consultar(Consulta.class));

        dono_coluna.setCellValueFactory(new PropertyValueFactory<Consulta, String>("Dono"));
        animal_coluna.setCellValueFactory(new PropertyValueFactory<Consulta, String>("Animal"));
        data_coluna.setCellValueFactory(new PropertyValueFactory<Consulta, String>("Data"));
        valor_coluna.setCellValueFactory(new PropertyValueFactory<Consulta, String>("valor"));
        status_coluna.setCellValueFactory(new PropertyValueFactory<Consulta, String>("Status"));

        table_view.getItems().setAll(listaConsulta);

    }

    @FXML
    private void onClickbtnFinalizar(ActionEvent event) {
        DAO dao = new DAO();
        Consulta consulta = table_view.getSelectionModel().getSelectedItem();
        if (consulta.getStatus().equals("Realizada")) {
            consulta.setStatus("Pago");
            dao.update(consulta);   
            table_view.getItems().setAll(listaConsulta);
        } else {
            showMessageDialog(null, "Exame já Pago");
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
