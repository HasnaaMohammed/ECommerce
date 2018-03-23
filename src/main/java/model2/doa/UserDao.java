package model2.doa;

import model2.interfaces.DaoInterface;
import model2.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDao implements DaoInterface<UserEntity> {

    private static UserDao instance;
    private EntityManager entityManager;
    public static UserDao getInstance()
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
    public void insert(UserEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(UserEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<UserEntity> select(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public void delete(UserEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public UserEntity getProductByID(int id) {
        return entityManager.find(UserEntity.class , id);

    }

}
