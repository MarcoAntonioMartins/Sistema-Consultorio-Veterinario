
package controladores;

import DAO.DAO;
import entidades.Dono;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import main.VeterinariaScoobyDoo;
import static relatorios.Gerador.geraRelatorioClientes;
import static relatorios.Gerador.geraRelatorioConsulta;

public class RelatoriosController implements Initializable {

    DAO dao = new DAO();

    @FXML
    private DatePicker dpDate;

    @FXML
    private Button btnGerarRelatorioData;
    @FXML
    private Button btnGerarRelatorioCliente;

    private ArrayList<Dono> listaDono;
    @FXML
    private ComboBox<Dono> cbCliente;
    @FXML
    private Button btnVoltar;
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaDono = new ArrayList<>(dao.consultar(Dono.class));
        cbCliente.getItems().setAll(listaDono);
    }

    @FXML
    private void onClickbtnGerarRelatorioData(ActionEvent event) {
        
        
        geraRelatorioConsulta();
        
        
    }

    @FXML
    private void onClickbtnGerarRelatorioCliente(ActionEvent event) {
        
               
        int codDono = cbCliente.getSelectionModel().getSelectedItem().getCodDono();

        geraRelatorioClientes();
        
        if (codDono == 0) {
            //txtFunc.setVisible(true);
        } else {
            //Gerador.gerarRelatorio(codDono);
        }
    }
    
    
    @FXML
    private void onClickbtnVoltar(ActionEvent event) {
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
