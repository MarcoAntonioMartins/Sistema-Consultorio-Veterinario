package DAO;

import entidades.ItemConsulta;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DAOItemConsulta extends DAO {

    public boolean registraProdutoUsado(String nome, String descricao, double valor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(ItemConsulta.class);
        crit.add(Restrictions.eq("Nome", nome));
        crit.add(Restrictions.eq("Valor", valor));
        crit.add(Restrictions.eq("Descricao", descricao));
        List results = crit.list();
        return !results.isEmpty();
    }
   
}
