package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Customer;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

//            Customer c3 = session.getReference(Customer.class, 3);
//            session.delete(c3);

//            Customer c50 = session.getReference(Customer.class, 50);
//            session.remove(c50);

            session.remove(new Customer(2, null, null, null));

            session.getTransaction().commit();
        }
    }
}
