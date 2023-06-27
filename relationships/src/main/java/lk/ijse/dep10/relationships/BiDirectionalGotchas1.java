package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Customer;
import lk.ijse.dep10.relationships.entity.Order;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BiDirectionalGotchas1 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            /* This seems fine */
//            Order order2 = session.get(Order.class, 2);
//            Customer nuwan = session.getReference(Customer.class, 2);
//
//            System.out.println(order2.getCustomer().getName());  // Kasun
//            order2.setCustomer(nuwan);

            /* This doesn't work, but why? */
//            Customer kasun = session.get(Customer.class, 1);
//            Order order2 = session.get(Order.class, 2);
//
//            kasun.getOrderList().add(order2);

            /* This works because we use a helper method here */
            Customer kasun = session.get(Customer.class, 1);
            Order order2 = session.get(Order.class, 2);

            kasun.addOrder(order2);

            session.getTransaction().commit();
        }
    }
}
