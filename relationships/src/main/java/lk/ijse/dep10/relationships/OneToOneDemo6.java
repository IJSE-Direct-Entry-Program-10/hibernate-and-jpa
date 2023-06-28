package lk.ijse.dep10.relationships;

import jakarta.persistence.FlushModeType;
import lk.ijse.dep10.relationships.entity.Car;
import lk.ijse.dep10.relationships.entity.Manager;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo6 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Manager martin = session.get(Manager.class, 3);
            Car mclaren = session.find(Car.class, "III-4567891");

            Manager meema = session.get(Manager.class, 2);
            Car ferari = session.find(Car.class, "EDF-7896541");

            mclaren.setManager(null);
            ferari.setManager(martin);
            session.flush();
            mclaren.setManager(meema);

            session.getTransaction().commit();
        }
    }
}
