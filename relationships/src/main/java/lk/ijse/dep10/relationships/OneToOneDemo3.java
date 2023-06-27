package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Employee;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo3 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Employee paniya = session.get(Employee.class, 1);
            System.out.println(session.contains(paniya));
            System.out.println(session.contains(paniya.getSpouse()));

            session.getTransaction().commit();
        }
    }
}
