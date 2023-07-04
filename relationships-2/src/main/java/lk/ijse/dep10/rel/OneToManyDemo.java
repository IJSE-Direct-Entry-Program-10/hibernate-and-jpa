package lk.ijse.dep10.rel;

import lk.ijse.dep10.rel.entity.Customer;
import lk.ijse.dep10.rel.entity.CustomerOrder;
import lk.ijse.dep10.rel.entity.Order;
import lk.ijse.dep10.rel.util.HibernateUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();

            Customer c001 = new Customer("C001", "Kasun");
            Customer c002 = new Customer("C002", "Nuwan");
            Customer c003 = new Customer("C003", "Ruwan");

            Order od1 = new Order("OD001", Date.valueOf(LocalDate.now()), new BigDecimal("100.00"));
            Order od2 = new Order("OD002", Date.valueOf(LocalDate.now()), new BigDecimal("200.00"));
            Order od3 = new Order("OD003", Date.valueOf(LocalDate.now()), new BigDecimal("300.00"));
            Order od4 = new Order("OD004", Date.valueOf(LocalDate.now()), new BigDecimal("150.00"));
            Order od5 = new Order("OD005", Date.valueOf(LocalDate.now()), new BigDecimal("270.00"));

            CustomerOrder c01 = new CustomerOrder(od1, c001,
                    od1.getTotal().multiply(new BigDecimal(3))
                    .divide(new BigDecimal(100)).intValue());

            CustomerOrder c02 = new CustomerOrder(od4, c001,
                    od4.getTotal().multiply(new BigDecimal(3))
                            .divide(new BigDecimal(100)).intValue());

            CustomerOrder c03 = new CustomerOrder(od2, c002,
                    od2.getTotal().multiply(new BigDecimal(3))
                            .divide(new BigDecimal(100)).intValue());

            CustomerOrder c04 = new CustomerOrder(od3, c002,
                    od3.getTotal().multiply(new BigDecimal(3))
                            .divide(new BigDecimal(100)).intValue());

            CustomerOrder c05 = new CustomerOrder(od5, c003,
                    od5.getTotal().multiply(new BigDecimal(3))
                            .divide(new BigDecimal(100)).intValue());

            List.of(c001, c002, c003, od1, od2, od3, od4, od5, c01, c02, c03, c04, c05)
                            .forEach(session::persist);

            session.getTransaction().commit();
        }
    }
}
