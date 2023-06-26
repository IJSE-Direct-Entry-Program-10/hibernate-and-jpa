package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Customer;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemo {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            Customer c1 = session.get(Customer.class, 1);
            System.out.println("Is c1 inside the context? " + session.contains(c1));    // true
            session.detach(c1);
            System.out.println(c1);
            System.out.println("Is c1 inside the context? " + session.contains(c1));    // false
            c1.setAddress("UAE");
            c1.setName("Kalhara");
            System.out.println(c1);
            session.refresh(c1);    // SELECT
            System.out.println("Is c1 inside the context? " + session.contains(c1));    // true
            System.out.println(c1);

        }
    }
}
