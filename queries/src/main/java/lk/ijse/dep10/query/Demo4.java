package lk.ijse.dep10.query;

import lk.ijse.dep10.query.entity.Employee;
import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class Demo4 {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();

            Query<Employee> query = session
                    .createQuery("FROM lk.ijse.dep10.query.entity.Employee e", Employee.class);
            List<Employee> list = query.list();

            list.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
