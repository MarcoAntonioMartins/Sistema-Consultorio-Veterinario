package DAO;

import entidades.Animal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DAOAnimal extends DAO {

    public List registraAnimal(String nome, String raca, String tipo, String idade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Animal.class);
        crit.add(Restrictions.eq("Nome", nome));
        crit.add(Restrictions.eq("Raca", raca));
        crit.add(Restrictions.eq("Tipo", tipo));
        crit.add(Restrictions.eq("Idade", idade));
        List animais = crit.list();
        return animais;
    }
}
