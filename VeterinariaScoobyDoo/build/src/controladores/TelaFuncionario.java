package controladores;

import DAO.DAO;
import DAO.DAOUsuario;
import DAO.DAOVeterinario;
import entidades.Dono;
import entidades.Usuario;
import entidades.Veterinario;
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
import javafx.scene.control.TextField;
import main.VeterinariaScoobyDoo;

public class TelaFuncionario implements Initializable {

    @FXML
    private Button Voltar;
    @FXML
    private Button Cadastrar;
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
    private TextField lblSenhaConfirmada;
    @FXML
    private TextField lblSenha;
    @FXML
    private TextField lblLogin;
    @FXML
    private ComboBox cbCargo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DAO dao = new DAO();
        
        cbCargo.getItems().add("Veterinario");
        cbCargo.getItems().add("Outro");

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

    @FXML
    private void onClickCadastrar(ActionEvent event) {
        Usuario usuario = new Usuario();

        usuario.setNome(lblNome.getText());
        usuario.setCpf(lblCpf.getText());
        usuario.setRg(lblRg.getText());
        usuario.setEndereco(lblEndereco.getText());
        usuario.setLogin(lblLogin.getText());
        usuario.setSenha(lblSenha.getText());
        usuario.setCargo(cbCargo.getSelectionModel().getSelectedItem().toString());
        usuario.setCelular(lblCelular.getText());
        usuario.setTelefone(lblTelefone.getText());

        if (cbCargo.getSelectionModel().getSelectedItem().toString() == "Veterinario") {
            Veterinario veterinario = new Veterinario();
            veterinario.setNome(lblNome.getText());
            veterinario.setCpf(lblCpf.getText());
            veterinario.setRg(lblRg.getText());
            veterinario.setEndereco(lblEndereco.getText());
            veterinario.setCargo(cbCargo.getSelectionModel().getSelectedItem().toString());
            veterinario.setTelefone(lblTelefone.getText());

            DAOVeterinario dao = new DAOVeterinario();
            dao.salvar(veterinario);
        } else {
        }

        DAOUsuario dao = new DAOUsuario();
        dao.salvar(usuario);
    }

}
