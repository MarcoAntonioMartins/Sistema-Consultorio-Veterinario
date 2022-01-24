package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.VeterinariaScoobyDoo;

public class TelaRetirarSenha implements Initializable {

    @FXML
    private Button Retirar;
    @FXML
    private Button Voltar;
    @FXML
    private Label lblSenhaNumero;

    private static int x;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lblSenhaNumero.setText(String.valueOf(x));

    }

    @FXML
    private void onClickRetirar(ActionEvent event) {
        x++;
        lblSenhaNumero.setText(String.valueOf(x));
        System.out.println("Senha impressa");
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

    public Label getLblSenhaNumero() {
        return lblSenhaNumero;
    }

    public void setLblSenhaNumero(Label lblSenhaNumero) {
        this.lblSenhaNumero = lblSenhaNumero;
    }

}
