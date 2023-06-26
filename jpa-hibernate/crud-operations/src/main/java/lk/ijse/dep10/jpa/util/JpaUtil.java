package lk.ijse.dep10.jpa.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class JpaUtil {
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        Properties jpaProps = new Properties();
        try(InputStream is = JpaUtil.class.getResourceAsStream("/application.properties");
            var bsr = new BufferedReader(new InputStreamReader(is))){
            jpaProps.load(bsr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Persistence.createEntityManagerFactory("dep-10", jpaProps);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
