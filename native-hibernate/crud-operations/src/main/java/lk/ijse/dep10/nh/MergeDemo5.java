package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Employee;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo5 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Employee e001 = session.find(Employee.class, "E001");   // managed
            session.detach(e001);
            Employee e001Cloned = session.merge(e001);
            e001Cloned.setAddress("ABC");
            e001.setAddress("EDF");

            session.getTransaction().commit();
        }
    }
}
