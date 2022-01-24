package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "dono_seq", sequenceName = "dono_seq",
        allocationSize = 1)
public class Dono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dono_seq")
    private int codDono;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String rg;
    private String Endereco;
    private String Celular;

    @OneToMany(mappedBy = "dono",
            targetEntity = Animal.class,
            fetch = FetchType.LAZY)
    private List<Animal> animais;
    
    @OneToMany(mappedBy = "dono",
            targetEntity = Consulta.class,
            fetch = FetchType.LAZY)
    private List<Consulta> consultas;

    public int getCodDono() {
        return codDono;
    }

    public void setCodDono(int codDono) {
        this.codDono = codDono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    @Override
    public String toString() {
        return nome;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    

}
