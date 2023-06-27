package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Employee;
import lk.ijse.dep10.relationships.entity.Spouse;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Employee paniya = new Employee(1, "Paniya", "Galle");
            Employee muga = new Employee(2, "Muga", "Matara");

            Spouse sadani = new Spouse(1, "Sadani", paniya);

            session.persist(paniya);
            session.persist(muga);
            session.persist(sadani);

            session.getTransaction().commit();
        }
    }
}
