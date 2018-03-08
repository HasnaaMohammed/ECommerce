package model.interfaces;

import model.beans.Order;

import java.sql.SQLException;
import java.util.Vector;

public interface OrderOperationInterface {

    public void addCartToOrder(int cartID);
    public Vector<Order> getAllOrders(String email) ;
     public Vector<Order> getAllOrders() ;

}
