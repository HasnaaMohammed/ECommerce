package controller.product;

import model.beans.Order;
import model.database.OrderOperation;
import model.interfaces.OrderOperationInterface;
import java.sql.SQLException;
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
}
