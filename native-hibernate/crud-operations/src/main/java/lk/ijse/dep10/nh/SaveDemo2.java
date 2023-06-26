package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Customer;
import lk.ijse.dep10.nh.entity.Employee;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Employee e1 = new Employee("E001", "Kasun", "Galle");
            System.out.println("Is e1 inside the context? " + session.contains(e1));
            session.persist(e1);    // transient -> managed
            System.out.println("Saved Here?");
            System.out.println("Is e1 inside the context? " + session.contains(e1));

            Customer c1 = new Customer("Kasun", "Galle", "077-1234567");
            System.out.println("Is c1 inside the context? " + session.contains(c1));
            session.persist(c1);    // transient -> managed
            System.out.println("Saved Here?");
            System.out.println("What is the id for c1?: " + c1.getId());
            System.out.println("Is c1 inside the context? " + session.contains(c1));

            session.getTransaction().commit();
        }
    }
}
