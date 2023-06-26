package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Customer;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveDemo {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Customer customer = new Customer(50,"Upul", "Matara", "032-1234567");
//            session.persist(customer);                // 6.x
//            var id = session.save(customer);          // 5.x
//            System.out.println("Customer ID: " + id);

            session.getTransaction().commit();
        }
    }
}
