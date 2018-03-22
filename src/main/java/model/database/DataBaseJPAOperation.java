package model.database;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBaseJPAOperation {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
        }
        return entityManagerFactory;
    }

    public static void open() {
        entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

    }
    public static void commit() {
        entityManager.getTransaction().commit();

    }

    public static void close() {
        entityManager.close();
    }


    public static void shutDown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

}


