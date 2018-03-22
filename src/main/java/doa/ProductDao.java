package doa;

import model.beans2.ProductEntity;
import model.interfaces.DaoInterface;

import java.util.List;

public class ProductDao implements DaoInterface<ProductEntity> {
    @Override
    public void persist(ProductEntity entity) {

    }

    @Override
    public void update(ProductEntity entity) {

    }

    @Override
    public ProductEntity select(String id) {
        return null;
    }

    @Override
    public void delete(ProductEntity entity) {

    }

    @Override
    public List<ProductEntity> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
