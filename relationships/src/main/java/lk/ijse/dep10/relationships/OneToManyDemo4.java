package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Customer;
import lk.ijse.dep10.relationships.entity.Order;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo4 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Customer ruwan = new Customer(3, "Ruwan", "089-1234567");
            List<Order> ruwanOrderList = List.of(
                    new Order(4, Date.valueOf(LocalDate.now()), ruwan),
                    new Order(5, Date.valueOf(LocalDate.now()), ruwan));
            ruwan.setOrderList(ruwanOrderList);

            Customer supun = new Customer(4, "Supun", "084-1234567");
            List<Order> supunOrderList = List.of(
                    new Order(6, Date.valueOf(LocalDate.now()), supun));
            supun.setOrderList(supunOrderList);

            session.persist(ruwan);
            session.persist(supun);

            session.getTransaction().commit();
        }
    }
}
