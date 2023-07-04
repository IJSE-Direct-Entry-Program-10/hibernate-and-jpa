package lk.ijse.dep10.query;

import lk.ijse.dep10.query.entity.Car;
import lk.ijse.dep10.query.entity.Employee;
import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class Demo5 {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();

            Query<Car> carQuery = session.createNamedQuery("query1", Car.class)
                    .setParameter("abc", "Bugati");
            Car car = carQuery.uniqueResult();
            System.out.println(car);

            session.getTransaction().commit();
        }
    }
}
