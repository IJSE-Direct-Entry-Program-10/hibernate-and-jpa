package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Customer;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadDemo {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
//            Customer c1 = session.load(Customer.class, 1);
            Customer c1 = session.getReference(Customer.class, 2);
            System.out.println("-------");
//            System.out.println(c1);
            System.out.println(c1.getName());
        }
    }
}
