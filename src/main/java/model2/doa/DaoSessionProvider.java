package model2.doa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DaoSessionProvider {

    private static volatile DaoSessionProvider instance;
    private EntityManager entityManager;
    private List<EntityManager> entityManagerList;

    public static DaoSessionProvider getInstance() {
        if (instance == null)
            instance = new DaoSessionProvider();
        return instance;
    }

    private DaoSessionProvider() {
        entityManagerList = new ArrayList<>();
    }

    private void sessionFactory() {
        entityManager = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();
    }

    public EntityManager getSession() {
        sessionFactory();
        entityManagerList.add(entityManager);
        return entityManager;
    }

    public void releaseObject(Object entity) {
        for (EntityManager entityManager : entityManagerList) {
            entityManager.detach(entity);
        }
    }

}
