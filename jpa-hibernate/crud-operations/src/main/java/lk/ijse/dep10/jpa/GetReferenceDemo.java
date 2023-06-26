package lk.ijse.dep10.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep10.jpa.entity.Customer;
import lk.ijse.dep10.jpa.util.JpaUtil;

public class GetReferenceDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager entityManager = emf.createEntityManager()) {
            Customer c1 = entityManager.getReference(Customer.class, 1);
            System.out.println("----");
            System.out.println(c1);
        }
    }
}
