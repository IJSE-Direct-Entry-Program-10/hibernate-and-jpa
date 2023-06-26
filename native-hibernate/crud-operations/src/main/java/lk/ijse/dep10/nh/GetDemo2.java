package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Customer;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Customer c1 = session.get(Customer.class, 1);
            System.out.println("Is c1 inside the context? " + session.contains(c1));
            session.evict(c1);
//            session.detach(c1);
            System.out.println("Is c1 inside the context? " + session.contains(c1));
            session.update(c1);

            session.getTransaction().commit();
        }
    }
}
