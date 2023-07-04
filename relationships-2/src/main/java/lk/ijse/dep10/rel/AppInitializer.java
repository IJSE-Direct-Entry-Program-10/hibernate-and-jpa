package lk.ijse.dep10.rel;

import lk.ijse.dep10.rel.util.HibernateUtil;

public class AppInitializer {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();
            System.out.println(session);
            session.getTransaction().commit();
        }
    }
}
