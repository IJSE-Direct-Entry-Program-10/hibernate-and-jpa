package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Module;
import lk.ijse.dep10.relationships.entity.Teacher;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyDemo8 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Module pfModule = session.get(Module.class, "CS001");

            /* This is how we delete a record from the associate entity */
            pfModule.setTeacher(null);

            session.getTransaction().commit();
        }
    }
}
