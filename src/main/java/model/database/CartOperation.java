package model.database;

import model.beans.Cart;
import model.beans.User;
import model.interfaces.CartOperationInterface;

import java.sql.SQLException;
import java.util.Vector;

public class CartOperation implements CartOperationInterface {

    @Override
    public Cart getUserUnpaidCart(String email) {
       return null;
    }


    @Override
    public Vector<Cart> getUserpaidCart(String email) {
        return null;
    }
}
