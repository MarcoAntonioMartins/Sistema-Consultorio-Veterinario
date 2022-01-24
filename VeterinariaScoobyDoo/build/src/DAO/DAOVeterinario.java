package DAO;

import entidades.Veterinario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DAOVeterinario extends DAO {
    public List registraVeternario(String nome, String cpf, String telefone, String rg, String endereco, String cargo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Veterinario.class);
        crit.add(Restrictions.eq("Nome", nome));
        crit.add(Restrictions.eq("CPF", cpf));
        crit.add(Restrictions.eq("Telefone", telefone));
        crit.add(Restrictions.eq("Rg", rg));
        crit.add(Restrictions.eq("Endereco", endereco));
        crit.add(Restrictions.eq("Cargo", cargo));
        List dono = crit.list();
        return dono;
    }

}
