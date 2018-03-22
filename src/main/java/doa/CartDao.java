package doa;

import model.beans2.CartEntity;
import model.interfaces.DaoInterface;

import java.util.List;

public class CartDao implements DaoInterface<CartEntity> {
    @Override
    public void persist(CartEntity entity) {

    }

    @Override
    public void update(CartEntity entity) {

    }

    @Override
    public CartEntity select(String id) {
        return null;
    }

    @Override
    public void delete(CartEntity entity) {

    }

    @Override
    public List<CartEntity> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
