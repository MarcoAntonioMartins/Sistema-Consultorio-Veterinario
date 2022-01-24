package controladores;

import DAO.DAO;
import DAO.DAOConsulta;
import DAO.DAOItemConsulta;
import entidades.Animal;
import entidades.Consulta;
import entidades.Dono;
import entidades.ItemConsulta;
import entidades.ItemConsultaPk;
import entidades.Produto;
import entidades.Veterinario;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javax.swing.JOptionPane.showMessageDialog;
import main.VeterinariaScoobyDoo;

public class TelaConsulta implements Initializable {

    @FXML
    private Button btnFinalizar;
    @FXML
    private ComboBox<Produto> cbItemUsado;
    @FXML
    private ComboBox<Animal> cbAnimal;
    @FXML
    private ComboBox<Dono> cbDono;
    @FXML
    private ComboBox<Veterinario> cbVeterinario;
    @FXML
    private TableView<ItemConsulta> table_view;
    @FXML
    private TableColumn<ItemConsulta, String> nome_coluna;
    @FXML
    private TableColumn<ItemConsulta, String> quantidade_coluna;
    @FXML
    private TableColumn<ItemConsulta, String> valor_coluna;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnAdicionar;
    @FXML
    private TextField txtSenhaN;
    @FXML
    private TextField txtQtd;
    @FXML
    private Button btnAtt_Consulta;
    @FXML
    private TextField txtTotal;

    private ArrayList<Produto> listaProduto;
    private ArrayList<Veterinario> listaVeterinario;
    private ArrayList<Animal> listaAnimal;
    private ArrayList<Dono> listaDono;
    private ArrayList<Produto> listaProdutoUsados;

    private Date hoje = new Date();
    private double total;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DAO dao = new DAO();
        DAOConsulta daoConsulta = new DAOConsulta();
        listaProduto = new ArrayList<>(dao.consultar(Produto.class));
        cbItemUsado.getItems().setAll(listaProduto);

        listaDono = new ArrayList<>(dao.consultar(Dono.class));
        cbDono.getItems().setAll(listaDono);

        listaVeterinario = new ArrayList<>(dao.consultar(Veterinario.class));
        cbVeterinario.getItems().setAll(listaVeterinario);

        nome_coluna.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getChaveComposta().getProduto().getNome()));
        quantidade_coluna.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getQuantidade() + ""));
        valor_coluna.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getChaveComposta().getProduto().getValor() + ""));
    }

    @FXML
    private void onClickbtnFinalizar(ActionEvent event) {
        DAO dao = new DAO();
        Consulta consulta = new Consulta();
        consulta.setSenha(txtSenhaN.getText());
        consulta.setAnimal(cbAnimal.getSelectionModel().getSelectedItem());
        consulta.setData(hoje);
        consulta.setStatus("Realizada");
        consulta.setVeterinario(cbVeterinario.getSelectionModel().getSelectedItem());
        consulta.setDono(cbDono.getSelectionModel().getSelectedItem());
        consulta.setValor(total);
        dao.salvar(consulta);

        for (int i = 0; i < table_view.getItems().size(); i++) {
            ItemConsulta itemconsulta = table_view.getItems().get(i);
            itemconsulta.getChaveComposta().setConsulta(consulta);
            dao.salvar(itemconsulta);
        }
        showMessageDialog(null, "Exame efetuado, aguardando pagamento");
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
    private void onClickbtnAdicionar(ActionEvent event) {
        DAO dao = new DAO();
        Produto produto = cbItemUsado.getSelectionModel().getSelectedItem();
        int quantidade = Integer.valueOf(txtQtd.getText());

        ItemConsultaPk itemConsultaPk = new ItemConsultaPk();
        itemConsultaPk.setProduto(produto);

        ItemConsulta itemConsulta = new ItemConsulta();
        itemConsulta.setChaveComposta(itemConsultaPk);
        itemConsulta.setQuantidade(quantidade);

        table_view.getItems().add(itemConsulta);

        total += produto.getValor() * quantidade;
        txtTotal.setText(String.valueOf(total));
    }

    @FXML
    private void onClickcbDono(ActionEvent event) {
        ArrayList<Animal> lista = new ArrayList<>(DAOConsulta.getAnimaisDono(cbDono.getSelectionModel().getSelectedItem()));
        cbAnimal.getItems().setAll(lista);
    }

    @FXML
    private void onClickbtnAtt_Consulta(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/Pagamento.fxml"));
            Scene scene = new Scene(root);
            VeterinariaScoobyDoo.stage.setScene(scene);
            VeterinariaScoobyDoo.stage.show();
        } catch (Exception e) {
            System.out.println("ERRO AO ABRIR TELA MAIN");
        }

    }

    @FXML
    private void onClickbtnRemover(ActionEvent event) {
        ItemConsulta itemconsulta = table_view.getSelectionModel().getSelectedItem();
        if (itemconsulta == null) {
            System.out.println("Nenhum Item Selecionado");
        } else {
            table_view.getItems().remove(itemconsulta);
            total -= itemconsulta.getQuantidade() * itemconsulta.getChaveComposta().getProduto().getValor();
            txtTotal.setText(String.valueOf(total));

        }
    }
}
