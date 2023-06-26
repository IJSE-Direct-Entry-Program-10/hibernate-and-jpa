package lk.ijse.dep10.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep10.jpa.entity.Customer;
import lk.ijse.dep10.jpa.util.JpaUtil;

public class UpdateDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager entityManager = emf.createEntityManager()) {
            entityManager.getTransaction().begin();

            Customer c3 = entityManager.find(Customer.class, 3);
            c3.setAddress("Colombo 5");

            entityManager.getTransaction().commit();
        }
    }
}
