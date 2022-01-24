package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemConsulta implements Serializable {

    @EmbeddedId
    private ItemConsultaPk chaveComposta;
    private int quantidade;

    public ItemConsultaPk getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(ItemConsultaPk chaveComposta) {
        this.chaveComposta = chaveComposta;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
