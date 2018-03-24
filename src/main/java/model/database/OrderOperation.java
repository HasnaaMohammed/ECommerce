package model.database;

import model.beans.Order;
import model2.adapter.EntityAdapter;
import model2.doa.OrderDao;
import model2.entity.CartEntity;
import model2.entity.OrderEntity;
import model2.interfaces.OrderOperationInterface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

public class OrderOperation implements OrderOperationInterface {

    private DatabaseHandler databaseHandler;
    private ResultSet resultSet;
    private OrderDao orderDao = OrderDao.getInstance();

    public OrderOperation() {
        databaseHandler = DatabaseHandler.getInstance();
    }

    @Override
    public void addCartToOrder(int cartID) {

    }
    //Converted
    @Override
    public Vector<Order> getAllOrders(String email) {

        String orderQuery = "select o from OrderEntity o where o.cartByCartId.userByUserId.email = '" + email + "'";
        List<OrderEntity> orderEntities = orderDao.select(orderQuery);
        Vector<Order> orders = new Vector<>();
        if (orderEntities != null && orderEntities.size() > 0)
            for (OrderEntity orderEntity : orderEntities) {
                orders.add(EntityAdapter.orderAdapter(orderEntity));
            }
        return orders;

    }
    //Converted
    @Override
    public Vector<Order> getAllOrders() {
        Vector<Order> orders = new Vector<>();
        String orderQuery = "select o from OrderEntity o";
        List<OrderEntity> orderEntities = orderDao.select(orderQuery);
        if(orderEntities != null && orderEntities.size() > 0){
            for(OrderEntity orderEntity : orderEntities)
            {
                orders.add(EntityAdapter.orderAdapter(orderEntity));
            }
        }

        return orders;
    }
    //Converted
    @Override
    public boolean createNewOrder(int cartID, double totalPrice) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTotalPrice(totalPrice);
        orderEntity.setTimestamp(new Timestamp(Calendar.getInstance().getTime().getTime()));
        CartEntity cartEntity = new CartOperation().getCartByID(cartID);
        orderEntity.setCartByCartId(cartEntity);
        orderDao.insert(orderEntity);
        return true;
    }

}
