package lk.ijse.dep10.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep10.jpa.entity.Customer;
import lk.ijse.dep10.jpa.util.JpaUtil;

public class RefreshDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager entityManager = emf.createEntityManager()) {

            Customer c1 = entityManager.find(Customer.class, 1);
            System.out.println("Is c1 inside the context? " + entityManager.contains(c1));    // true
            entityManager.detach(c1);
            System.out.println(c1);
            System.out.println("Is c1 inside the context? " + entityManager.contains(c1));    // false
            c1.setAddress("UAE");
            c1.setName("Kalhara");
            System.out.println(c1);
            entityManager.refresh(c1);    // SELECT
            System.out.println("Is c1 inside the context? " + entityManager.contains(c1));    // true
            System.out.println(c1);

        }
    }
}
