package DAO;

import entidades.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DAOUsuario extends DAO {

    public boolean validaLogin(String login, String senha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Usuario.class);
        crit.add(Restrictions.eq("login", login));
        crit.add(Restrictions.eq("senha", senha));
        List results = crit.list();
        return !results.isEmpty();
    }
}
