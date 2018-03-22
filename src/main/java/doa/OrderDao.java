package doa;

import model.beans2.OrderEntity;
import model.interfaces.DaoInterface;

import java.util.List;

public class OrderDao implements DaoInterface<OrderEntity> {
    @Override
    public void persist(OrderEntity entity) {

    }

    @Override
    public void update(OrderEntity entity) {

    }

    @Override
    public OrderEntity select(String id) {
        return null;
    }

    @Override
    public void delete(OrderEntity entity) {

    }

    @Override
    public List<OrderEntity> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
