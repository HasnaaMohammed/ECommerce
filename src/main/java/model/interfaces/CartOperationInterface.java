package model.interfaces;

import model.beans.Cart;
import model.beans.User;

import java.util.Vector;

public interface CartOperationInterface {


    public Cart getUserUnpaidCart(String email);
    public Vector<Cart> getUserpaidCart(String email);
}
