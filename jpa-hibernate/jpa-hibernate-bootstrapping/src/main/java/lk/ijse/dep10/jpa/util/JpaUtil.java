package lk.ijse.dep10.jpa.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.*;
import java.util.Properties;

public class JpaUtil {
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        Properties jpaProps = new Properties();

        try(InputStream is = JpaUtil.class.getResourceAsStream("/application.properties");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr)){
            jpaProps.load(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("dep-10", jpaProps);
        return entityManagerFactory;
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
