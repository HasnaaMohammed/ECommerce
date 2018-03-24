package model2.doa;

import model2.interfaces.DaoInterface;
import model2.entity.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OrderDao implements DaoInterface<OrderEntity> {


    private static OrderDao instance;
    private volatile EntityManager entityManager;
    public synchronized static OrderDao getInstance()
    {
        if (instance == null)
            instance = new OrderDao();
        return instance;
    }
    private OrderDao()
    {
        entityManager = DaoSessionProvider.getInstance().getSession();
    }

    @Override
    public synchronized void insert(OrderEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized void update(OrderEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<OrderEntity> select(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public synchronized void delete(OrderEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<OrderEntity> findAll() {
        return null;
    }

    @Override
    public synchronized OrderEntity getEntityByID(int id) {
        return entityManager.find(OrderEntity.class , id);

    }

}
