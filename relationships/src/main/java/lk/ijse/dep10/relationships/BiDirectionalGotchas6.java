package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Course;
import lk.ijse.dep10.relationships.entity.Employee;
import lk.ijse.dep10.relationships.entity.Spouse;
import lk.ijse.dep10.relationships.entity.Student;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BiDirectionalGotchas6 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Student pt = session.get(Student.class, "S003");
            Course dep = session.get(Course.class, "DEP");

            /* Inverse End */
//            pt.getCourseList().remove(dep);

            /* Owner End */
            dep.getStudentSet().remove(pt);

            session.getTransaction().commit();
        }
    }
}
