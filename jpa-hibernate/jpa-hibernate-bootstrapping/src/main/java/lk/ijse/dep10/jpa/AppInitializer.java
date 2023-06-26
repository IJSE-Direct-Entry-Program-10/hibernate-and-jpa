package lk.ijse.dep10.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep10.jpa.util.JpaUtil;

public class AppInitializer {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager entityManager = emf.createEntityManager()) {

            System.out.println(entityManager);

        }
    }
}
