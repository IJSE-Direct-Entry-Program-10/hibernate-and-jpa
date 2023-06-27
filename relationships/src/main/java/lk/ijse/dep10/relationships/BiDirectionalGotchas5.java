package lk.ijse.dep10.relationships;

import lk.ijse.dep10.relationships.entity.Employee;
import lk.ijse.dep10.relationships.entity.Spouse;
import lk.ijse.dep10.relationships.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BiDirectionalGotchas5 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Employee muga = session.getReference(Employee.class, 2);
            Spouse sadani = session.get(Spouse.class, 1);
            sadani.setEmployee(muga);

            Employee paniya = session.get(Employee.class, 1);
            paniya.setSpouse(sadani);
            paniya.setSpouse(sadani);
            paniya.setSpouse(sadani);
            paniya.setSpouse(sadani);
            paniya.setSpouse(sadani);
            paniya.setSpouse(sadani);

            session.getTransaction().commit();
        }
    }
}
