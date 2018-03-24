package model2.doa;

import model2.interfaces.DaoInterface;
import model2.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDao implements DaoInterface<UserEntity> {

    private static UserDao instance;
    private volatile EntityManager entityManager;
    public synchronized static UserDao getInstance()
    {
        if (instance == null)
            instance = new UserDao();
        return instance;
    }
    private UserDao()
    {
        entityManager = DaoSessionProvider.getInstance().getSession();
    }

    @Override
    public synchronized  void insert(UserEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized void update(UserEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<UserEntity> select(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public synchronized void delete(UserEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<UserEntity> findAll() {
        return null;
    }

    @Override
    public synchronized UserEntity getEntityByID(int id) {
        return entityManager.find(UserEntity.class , id);

    }

}
