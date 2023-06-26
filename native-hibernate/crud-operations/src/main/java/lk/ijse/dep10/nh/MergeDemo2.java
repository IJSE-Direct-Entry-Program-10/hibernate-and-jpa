package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Employee;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Employee e001 = session.find(Employee.class, "E001");   // managed
            System.out.println("Is E001 inside the context? " + session.contains(e001)); // true
            session.evict(e001);
            System.out.println("Is E001 inside the context? " + session.contains(e001)); // false
            Employee e001Cloned1 = session.find(Employee.class, "E001");
            System.out.println("Is e001Cloned1 inside the context? " + session.contains(e001Cloned1));
            Employee clonedE001 = session.merge(e001);
            System.out.println("Is E001 inside the context? " + session.contains(e001)); // false
            System.out.println("Is clonedE001 inside the context? " + session.contains(clonedE001)); // true?
            System.out.println(clonedE001 == e001Cloned1);

            /*
            * SELECT
            * true
            * false
            * SELECT
            * true
            * false
            * true
            * true
            * */

            session.getTransaction().commit();
        }
    }
}
