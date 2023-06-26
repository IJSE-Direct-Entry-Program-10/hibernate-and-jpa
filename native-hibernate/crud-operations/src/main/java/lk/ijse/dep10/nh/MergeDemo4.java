package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Employee;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo4 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Employee e001 = session.find(Employee.class, "E001");   // managed
            session.detach(e001);
            Employee e001Clone = session.getReference(Employee.class, "E001");
            System.out.println("-----");
            Employee e001Clone2 = session.merge(e001);
            System.out.println(e001Clone == e001Clone2);

            /*
            * SELECT
            * ------
            * SELECT
            * */

            session.getTransaction().commit();
        }
    }
}
