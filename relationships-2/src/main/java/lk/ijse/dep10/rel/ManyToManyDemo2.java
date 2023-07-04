package lk.ijse.dep10.rel;

import lk.ijse.dep10.rel.entity.Course;
import lk.ijse.dep10.rel.entity.Student;
import lk.ijse.dep10.rel.entity.StudentCourse;
import lk.ijse.dep10.rel.util.HibernateUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ManyToManyDemo2 {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();

            Student s001 = new Student("S001", "Kasun", "078-1234567");
            Student s002 = new Student("S002", "Nuwan", "077-1234567");
            Student s003 = new Student("S003", "Ruwan", "071-1234567");

            Course dep = new Course("DEP", "Direct Entry Program", "05 Months");
            Course cmjd = new Course("CMJD", "Comprehensive Master Java Developer", "06 Months");
            Course gdse = new Course("GDSE", "Graduate Diploma in Software Engineering", "02 Years");

            StudentCourse sc1 = new StudentCourse(s001.getId(), dep.getId(), Date.valueOf(LocalDate.now()), "Career Change");
            StudentCourse sc2 = new StudentCourse(s002.getId(), dep.getId(), Date.valueOf(LocalDate.now()), "Career Change");
            StudentCourse sc3 = new StudentCourse(s003.getId(), gdse.getId(), Date.valueOf(LocalDate.now()), "Career Change");
            StudentCourse sc4 = new StudentCourse(s002.getId(), cmjd.getId(), Date.valueOf(LocalDate.now()), "Career Change");
            StudentCourse sc5 = new StudentCourse(s003.getId(), cmjd.getId(), Date.valueOf(LocalDate.now()), "Career Change");
            StudentCourse sc6 = new StudentCourse(s001.getId(), cmjd.getId(), Date.valueOf(LocalDate.now()), "Career Change");

            List.of(s001, s002, s003, dep, cmjd, gdse, sc1, sc2, sc3, sc4, sc5, sc6)
                            .forEach(session::persist);

            session.getTransaction().commit();
        }
    }
}
