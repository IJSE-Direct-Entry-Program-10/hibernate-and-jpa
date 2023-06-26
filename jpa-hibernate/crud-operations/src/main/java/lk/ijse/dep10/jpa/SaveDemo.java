package lk.ijse.dep10.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep10.jpa.entity.Customer;
import lk.ijse.dep10.jpa.util.JpaUtil;

public class SaveDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager entityManager = emf.createEntityManager()) {
            entityManager.getTransaction().begin();

            Customer customer = new Customer("Kasun", "Galle", "077-1234567");
            entityManager.persist(customer);

            entityManager.getTransaction().commit();
        }
    }
}
