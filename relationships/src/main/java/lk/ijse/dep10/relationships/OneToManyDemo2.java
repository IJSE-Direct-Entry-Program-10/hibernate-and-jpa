package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Customer;
import lk.ijse.dep10.relationships.entity.Order;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Order order1 = session.get(Order.class, 1);
            System.out.println("Is order-1 inside the context? " + session.contains(order1));
            Customer kasun = order1.getCustomer();
            System.out.println("Is kasun inside the context? " + session.contains(kasun));

            session.getTransaction().commit();
        }
    }
}
