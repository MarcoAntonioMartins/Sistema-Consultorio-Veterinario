package controladores;

import DAO.DAOUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.VeterinariaScoobyDoo;
import static main.VeterinariaScoobyDoo.stage;
import static org.hibernate.annotations.common.util.StringHelper.root;

public class TelaLoginController implements Initializable {

    @FXML
    private TextField txtNomeUsuario;
    @FXML
    private TextField txtSenhaUsuario;
    @FXML
    private Button btnLogar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onClickBtnLogar() throws IOException {
        DAOUsuario dao = new DAOUsuario();
        ArrayList<Usuario> lista;
        boolean contem = dao.validaLogin(txtNomeUsuario.getText(), txtSenhaUsuario.getText());
        if (!contem) {
            System.out.println("Login ou Senha Incorreto");
        } else {
            System.out.println("Acesso Autorizado");
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

}
