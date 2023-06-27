package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Course;
import lk.ijse.dep10.relationships.entity.Student;
import lk.ijse.dep10.relationships.entity.util.Gender;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Course dep = session.get(Course.class, "DEP");
            Course cmjd = session.get(Course.class, "CMJD");
            Student john = session.get(Student.class, "S001");

            dep.getStudentSet().remove(john);
            cmjd.getStudentSet().add(john);

            session.getTransaction().commit();
        }
    }
}
