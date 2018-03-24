package model2.doa;


import model2.entity.CartProductEntity;
import model2.interfaces.DaoInterface;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CartProductDao implements DaoInterface<CartProductEntity> {


    private static CartProductDao instance;
    private volatile EntityManager entityManager;
    public synchronized static CartProductDao getInstance()
    {
        if (instance == null)
            instance = new CartProductDao();
        return instance;
    }
    private CartProductDao()
    {
        entityManager = DaoSessionProvider.getInstance().getSession();
    }

    @Override
    public synchronized void insert(CartProductEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized void update(CartProductEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<CartProductEntity> select(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public synchronized void delete(CartProductEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<CartProductEntity> findAll() {
        return null;
    }

    @Override
    public CartProductEntity getEntityByID(int id) {
        return entityManager.find(CartProductEntity.class , id);

    }


}
