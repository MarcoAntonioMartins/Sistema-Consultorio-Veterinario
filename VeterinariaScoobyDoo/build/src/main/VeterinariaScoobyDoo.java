package main;

import DAO.DAO;
import entidades.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VeterinariaScoobyDoo extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        VeterinariaScoobyDoo.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/telas/Tela_Main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


/*Atualizar

        DAOUsuario dao = new DAOUsuario();
        ArrayList<Usuario> lista;
        lista = (ArrayList<Usuario>) dao.validaLogin("allanfraga", "1234");
        Usuario usuario = lista.get(0);
        usuario.setNome("Allan Fraga");
        dao.update(usuario);
 */

 /*Salvar um dado

        Usuario usuario = new Usuario ();
        usuario.setNome ("");
        usuario.setLogin ("");
        usuario.setSenha ("");
        usuario.setCargo("");
 */

 /*Consultar um dado

        DAO dao = new DAO();
        ArrayList <Usuario> lista;
        lista = (ArrayList <Usuario>) dao.consultar(Usuario.class);
        for (int i = 0; i < lista.size();i++){
        System.out.println(lista.get(i).getNome());
        }
 */

        /*Excluindo um dado

        DAOUsuario dao = new DAOUsuario();
        ArrayList <Usuario> lista;
        lista = (ArrayList <Usuario>) dao.validaLogin("ortoncelli","1234");
        Usuario usuario = lista.get(0);
        usuario.setNome("Antonio");
        dao.delete(usuario);
        */
