package DAO;

import entidades.Dono;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DAODono extends DAO {


    public List registraDono(String nome, String cpf, String telefone, String email, String rg, String endereco, String celular) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Dono.class);
        crit.add(Restrictions.eq("Nome", nome));
        crit.add(Restrictions.eq("CPF", cpf));
        crit.add(Restrictions.eq("Telefone", telefone));
        crit.add(Restrictions.eq("Email", email));
        crit.add(Restrictions.eq("Rg", rg));
        crit.add(Restrictions.eq("Endereco", endereco));
        crit.add(Restrictions.eq("Celular", celular));
        List dono = crit.list();
        return dono;
    }
}
