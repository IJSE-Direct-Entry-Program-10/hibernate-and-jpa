package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Course;
import lk.ijse.dep10.relationships.entity.Student;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ManyToManyDemo3 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Student pt = session.get(Student.class, "S003");
            List<Course> courseList = pt.getCourseList();
            System.out.println("----------");
            System.out.println(courseList.get(0));

            session.getTransaction().commit();
        }
    }
}
