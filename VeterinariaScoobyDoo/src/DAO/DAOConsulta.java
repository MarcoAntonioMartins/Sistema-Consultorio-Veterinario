package DAO;

import entidades.Animal;
import entidades.Consulta;
import entidades.Dono;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DAOConsulta extends DAO {

    public List registraProduto(Integer data, Integer codconsulta, double valor, String status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Consulta.class);
        crit.add(Restrictions.eq("Constula N", codconsulta));
        crit.add(Restrictions.eq("Data", data));
        crit.add(Restrictions.eq("Valor", valor));
        crit.add(Restrictions.eq("Status", status));
        List consulta = crit.list();
        return consulta;
    }

    public static ArrayList<Animal> getAnimaisDono(Dono dono) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Animal.class);
        crit.add(Restrictions.eq("dono", dono));
        ArrayList<Animal> consulta = (ArrayList<Animal>) crit.list();
        return consulta;
    }

}
