package model2.doa;


import model2.interfaces.DaoInterface;
import model2.entity.CartEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CartDao implements DaoInterface<CartEntity> {

    private static CartDao instance;
    private volatile EntityManager entityManager;
    public synchronized static CartDao getInstance()
    {
        if (instance == null)
            instance = new CartDao();
        return instance;
    }
    private CartDao()
    {
        entityManager = DaoSessionProvider.getInstance().getSession();
    }

    @Override
    public synchronized void insert(CartEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized void update(CartEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<CartEntity> select(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();

    }

    @Override
    public synchronized void delete(CartEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<CartEntity> findAll() {

        Query query = entityManager.createQuery("select c from CartEntity c");
        return query.getResultList();

    }

    @Override
    public synchronized CartEntity getEntityByID(int id) {
        return entityManager.find(CartEntity.class , id);
    }

}
