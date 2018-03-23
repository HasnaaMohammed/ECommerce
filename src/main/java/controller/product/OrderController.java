package controller.product;

import model.beans.Order;
import model.database.OrderOperation;
import model2.interfaces.OrderOperationInterface;

import java.util.Vector;

public class OrderController {

    OrderOperationInterface orderOperation;
    public OrderController()
    {
        orderOperation = new OrderOperation();
    }

    public Vector<Order> getAllOrders(String email)
    {
            return orderOperation.getAllOrders(email);
    }
    public boolean createNewOrder(int cartID , double totalPrice)
    {
       return orderOperation.createNewOrder(cartID , totalPrice);
    }
}
