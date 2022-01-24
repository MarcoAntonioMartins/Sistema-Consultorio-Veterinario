package DAO;

import entidades.Produto;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DAOProduto extends DAO {

    public List registraProduto(String nome, String descricao, double valor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Produto.class);
        crit.add(Restrictions.eq("Nome", nome));
        crit.add(Restrictions.eq("Valor", valor));
        crit.add(Restrictions.eq("Descricao", descricao));
        List produto = crit.list();
        return produto;
    }
}
