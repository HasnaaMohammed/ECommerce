package model2.doa;

import model2.interfaces.DaoInterface;
import model2.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductDao implements DaoInterface<ProductEntity> {

    private static ProductDao instance;
    private EntityManager entityManager;
    public static ProductDao getInstance()
    {
        if (instance == null)
            instance = new ProductDao();
        return instance;
    }
    private ProductDao()
    {
        entityManager = DaoSessionProvider.getInstance().getSession();
    }

    @Override
    public void insert(ProductEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(ProductEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<ProductEntity> select(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public void delete(ProductEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<ProductEntity> findAll() {
        return null;
    }

    @Override
    public ProductEntity getEntityByID(int id) {
        return entityManager.find(ProductEntity.class , id);

    }

}
