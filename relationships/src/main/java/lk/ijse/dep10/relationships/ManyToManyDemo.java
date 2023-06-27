package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Course;
import lk.ijse.dep10.relationships.entity.Student;
import lk.ijse.dep10.relationships.entity.util.Gender;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Student john = new Student("S001", "John", "Matara", Gender.MALE);
            Student kasun = new Student("S002", "Kasun", "Galle", Gender.MALE);
            Student pt = new Student("S003", "PT", "Panadura", Gender.MALE);

            Course dep = new Course("DEP", "Direct Entry Program", 4);
            Course cmjd = new Course("CMJD", "Comprehensive Master Java Developer", 6);

            session.persist(john);
            session.persist(kasun);
            session.persist(pt);
            session.persist(dep);
            session.persist(cmjd);

            dep.getStudentSet().add(john);
            dep.getStudentSet().add(kasun);
            dep.getStudentSet().add(pt);

            cmjd.getStudentSet().add(pt);
            cmjd.getStudentSet().add(kasun);

            session.getTransaction().commit();
        }
    }
}
