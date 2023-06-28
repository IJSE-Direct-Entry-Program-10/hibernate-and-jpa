package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Module;
import lk.ijse.dep10.relationships.entity.Teacher;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyDemo7 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Teacher martin = new Teacher("T004", "Martin");
            session.persist(martin);

            Module angularModule = session.get(Module.class, "SE002");

            // Update
            angularModule.setTeacher(martin);

            session.getTransaction().commit();
        }
    }
}
