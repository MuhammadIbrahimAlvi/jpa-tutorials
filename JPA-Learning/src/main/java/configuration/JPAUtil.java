package configuration;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("default");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emFactory;
    }

    public static void shutdown() {
        if (emFactory != null && emFactory.isOpen()) {
            emFactory.close();
        }
    }
}
