package model2.doa;

import model2.entity.ProductEntity;
import model2.interfaces.DaoInterface;
import model2.entity.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CategoryDao implements DaoInterface<CategoryEntity> {

    private static CategoryDao instance;
    private volatile EntityManager entityManager;
    public synchronized static CategoryDao getInstance()
    {
        if (instance == null)
            instance = new CategoryDao();
        return instance;
    }
    private CategoryDao()
    {
        entityManager = DaoSessionProvider.getInstance().getSession();
    }


    @Override
    public synchronized void insert(CategoryEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized void update(CategoryEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<CategoryEntity> select(String queryString) {
        clearSession();
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public synchronized void delete(CategoryEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized List<CategoryEntity> findAll() {
        return null;
    }

    @Override
    public synchronized CategoryEntity getEntityByID(int id) {
        return entityManager.find(CategoryEntity.class , id);

    }

    public synchronized void clearSession()
    {
        if(entityManager != null)
            entityManager.clear();
    }

}
