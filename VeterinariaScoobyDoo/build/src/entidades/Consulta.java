package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "consulta_seq", sequenceName = "consulta_seq", allocationSize = 1)
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta_seq")
    private int codConsulta;

    @Column(name = "Data")
    private Date data;
    @Column(name = "Status")
    private String status;
    @Column(name = "Valor")
    private double valor;
    private String pagamento;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "codVeterinario")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "codDono")
    private Dono dono;

    @OneToMany(mappedBy = "itemConsulta", targetEntity = Consulta.class, fetch = FetchType.LAZY)
    private List<ItemConsulta> itemConsulta;

    @ManyToOne
    @JoinColumn(name = "codAnimal")
    private Animal animal;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public int getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(int codConsulta) {
        this.codConsulta = codConsulta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<ItemConsulta> getItemConsulta() {
        return itemConsulta;
    }

    public void setItemConsulta(List<ItemConsulta> itemConsulta) {
        this.itemConsulta = itemConsulta;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

}
