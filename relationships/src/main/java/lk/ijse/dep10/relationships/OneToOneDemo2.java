package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Employee;
import lk.ijse.dep10.relationships.entity.Spouse;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Spouse sadani = session.get(Spouse.class, 1);
            System.out.println("Is Sadani inside the context? " + session.contains(sadani)); // true
            Employee paniya = sadani.getEmployee();
            System.out.println("Is paniya also inside the context? " + session.contains(paniya));   // true

//            Employee paniya = session.get(Employee.class, 1);
//            System.out.println(paniya);

            session.getTransaction().commit();
        }
    }
}
