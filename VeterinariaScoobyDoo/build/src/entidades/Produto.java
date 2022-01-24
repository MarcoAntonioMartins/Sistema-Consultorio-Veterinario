package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javafx.scene.control.TextField;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq",
        allocationSize = 1)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    private int codProduto;
    private String nome;
    private double valor;
    private String validade;
    private String descricao;

    @OneToMany(mappedBy = "itemConsulta", targetEntity = Produto.class, fetch = FetchType.LAZY)
    private List<ItemConsulta> itemConsulta;

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome;
    }

    public List<ItemConsulta> getItemConsulta() {
        return itemConsulta;
    }

    public void setItemConsulta(List<ItemConsulta> itemConsulta) {
        this.itemConsulta = itemConsulta;
    }

}
