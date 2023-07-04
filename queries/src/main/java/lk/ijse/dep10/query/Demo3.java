package lk.ijse.dep10.query;

import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class Demo3 {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("FROM Employee e");// HQL
//            session.createQuery("SELECT e FROM Employee e");        // JPQL

            List list = query.list();
            list.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
