package lk.ijse.dep10.nh;

import lk.ijse.dep10.nh.entity.Employee;
import lk.ijse.dep10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveOrUpdateDemo {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Employee john = new Employee("E002", "John+", "Matara");
            session.saveOrUpdate(john);
            System.out.println("Is john inside the context? " + session.contains(john));

            session.getTransaction().commit();
        }
    }
}
