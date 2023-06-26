package lk.ijse.dep10.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep10.jpa.entity.Customer;
import lk.ijse.dep10.jpa.util.JpaUtil;

public class RemoveDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager entityManager = emf.createEntityManager()) {
            entityManager.getTransaction().begin();

            Customer c1 = entityManager.find(Customer.class, 1);
            entityManager.remove(c1);

            entityManager.getTransaction().commit();
        }
    }
}
