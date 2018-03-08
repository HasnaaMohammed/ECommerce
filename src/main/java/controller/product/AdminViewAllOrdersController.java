/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import java.util.Vector;
import model.beans.Order;
import model.database.OrderOperation;
import model.interfaces.OrderOperationInterface;

/**
 *
 * @author Asmaa
 */
public class AdminViewAllOrdersController {
    OrderOperationInterface orderOperationInterface;
    Vector<Order> orders;
    public Vector<Order> getOrderList(){
        orderOperationInterface=new OrderOperation();
        orders=orderOperationInterface.getAllOrders();
        return orders;
    }
}
