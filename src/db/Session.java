package db;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Session {
    private static final String PERSISTENCE_UNIT_NAME = "AL2000";

    private static Session instance;

    private final EntityManager entityManager;

    private Session() {
        entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    public static synchronized Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
