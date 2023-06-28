package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Car;
import lk.ijse.dep10.relationships.entity.Manager;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo4 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Manager lokka = new Manager(1, "Lokka");
            Manager meema = new Manager(2, "Meema");
            Manager martin = new Manager(3, "Martin");

            Car bugati = new Car("ABC-1234567", "Bugati", lokka);
            Car ferari = new Car("EDF-7896541", "Ferari", meema);
            Car mclaren = new Car("III-4567891", "Mclaren");

            session.persist(bugati);
            session.persist(ferari);

            session.persist(martin);
            session.persist(mclaren);

            session.getTransaction().commit();
        }
    }
}
