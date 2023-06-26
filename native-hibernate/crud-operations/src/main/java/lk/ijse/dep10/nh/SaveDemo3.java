package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Customer;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveDemo3 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Customer cNuwan = new Customer(10, "Nuwan", "Panadura", "098-1235467");
            System.out.println("Is Nuwan inside the context? " + session.contains(cNuwan));
            session.persist(cNuwan);   // transient -> managed

            session.getTransaction().commit();
        }
    }
}
