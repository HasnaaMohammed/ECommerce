package doa;

import model.beans2.CategoryEntity;
import model.interfaces.DaoInterface;

import java.util.List;

public class CategoryDao implements DaoInterface<CategoryEntity> {
    @Override
    public void persist(CategoryEntity entity) {

    }

    @Override
    public void update(CategoryEntity entity) {

    }

    @Override
    public CategoryEntity select(String id) {
        return null;
    }

    @Override
    public void delete(CategoryEntity entity) {

    }

    @Override
    public List<CategoryEntity> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
