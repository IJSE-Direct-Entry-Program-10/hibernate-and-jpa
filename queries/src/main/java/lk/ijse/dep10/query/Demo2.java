package lk.ijse.dep10.query;

import lk.ijse.dep10.query.util.HibernateUtil;
import lk.ijse.dep10.query.entity.Employee;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Demo2 {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();

            // Native Queries (Tables, Columns, Rows)
            // JPQL/HQL Queries (Entity Classes, Fields, Entity Instances)

            NativeQuery<Employee> nativeQuery = session.createNativeQuery("SELECT * FROM employee",
                                                                                    Employee.class);
            List<Employee> list = nativeQuery.list();

            list.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
