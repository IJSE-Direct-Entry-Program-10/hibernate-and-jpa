package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Car;
import lk.ijse.dep10.relationships.entity.Manager;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo5 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Manager martin = session.get(Manager.class, 3);
            Car mclaren = session.find(Car.class, "III-4567891");

            /* Add */
            mclaren.setManager(martin);

            session.getTransaction().commit();
        }
    }
}
