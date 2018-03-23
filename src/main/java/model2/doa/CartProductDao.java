package model2.doa;


import model2.entity.CartProductEntity;
import model2.interfaces.DaoInterface;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CartProductDao implements DaoInterface<CartProductEntity> {


    private static CartProductDao instance;
    private volatile EntityManager entityManager;
    public static CartProductDao getInstance()
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
    public void insert(CartProductEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(CartProductEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<CartProductEntity> select(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public void delete(CartProductEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<CartProductEntity> findAll() {
        return null;
    }

    @Override
    public CartProductEntity getProductByID(int id) {
        return entityManager.find(CartProductEntity.class , id);

    }


}
