package lk.ijse.dep10.query;

import lk.ijse.dep10.query.entity.Car;
import lk.ijse.dep10.query.entity.Employee;
import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class Demo6 {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();

            List<Employee> list = session.createNamedQuery("searchEmployees", Employee.class)
                    .setParameter("q", "%a%").list();
            list.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
