package model.interfaces;

import model.beans.Cart;
import model.beans.User;

public interface ProductOperationInterface {

    public Cart getUserCart(String email);
    public Cart getUserCart(User user);

    
}
