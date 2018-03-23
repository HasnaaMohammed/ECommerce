package model2.interfaces;

import model.beans.Order;

import java.util.Vector;

public interface OrderOperationInterface {

    public void addCartToOrder(int cartID);

    public Vector<Order> getAllOrders(String email);

    public Vector<Order> getAllOrders();

    public boolean createNewOrder(int cartID , double totalPrice) ;

}
