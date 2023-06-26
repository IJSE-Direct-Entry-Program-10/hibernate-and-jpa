package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Employee;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo3 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Employee e001 = session.find(Employee.class, "E001");   // managed
            session.detach(e001);
            Employee e001Clone = session.find(Employee.class, "E001");
            session.update(e001);
            System.out.println("Is e001 inside the context? " + session.contains(e001));
            System.out.println("Is e001Clone inside the context? " + session.contains(e001Clone));
            System.out.println(e001 == e001Clone);

            /*
            * SELECT
            * SELECT
            * Exception
            * */

            session.getTransaction().commit();
        }
    }
}
