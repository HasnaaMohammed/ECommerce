package model2.doa;

import model2.entity.ProductEntity;
import model2.interfaces.DaoInterface;
import model2.entity.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CategoryDao implements DaoInterface<CategoryEntity> {

    private static CategoryDao instance;
    private EntityManager entityManager;
    public static CategoryDao getInstance()
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
    public void insert(CategoryEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(CategoryEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<CategoryEntity> select(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public void delete(CategoryEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<CategoryEntity> findAll() {
        return null;
    }

    @Override
    public CategoryEntity getEntityByID(int id) {
        return entityManager.find(CategoryEntity.class , id);

    }

}
