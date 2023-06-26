package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Customer;
import lk.ijse.dep10.nh.entity.Employee;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo6 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Employee e003 = new Employee("E003", "Muga", "Kandy");
            Employee clonedE003 = session.merge(e003);
            System.out.println("Is e003 inside the context? " + session.contains(e003));
            System.out.println("Is clonedE003 inside the context? " + session.contains(clonedE003));

            session.getTransaction().commit();
        }
    }
}
