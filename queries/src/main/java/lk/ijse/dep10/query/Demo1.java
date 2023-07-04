package lk.ijse.dep10.query;

import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Demo1 {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();

            // Native Queries (Tables, Columns, Rows)
            // JPQL/HQL Queries (Entity Classes, Fields, Entity Instances)

            /* If you haven't specified the result class, you will get an object array */
            NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM employee");
            List<Object[]> list = nativeQuery.list();

            System.out.println(list.get(0)[0]); // id
            System.out.println(list.get(0)[1]); // name

            session.getTransaction().commit();
        }
    }
}
