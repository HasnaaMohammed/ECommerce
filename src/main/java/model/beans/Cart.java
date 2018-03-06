package model.beans;

import java.io.Serializable;
import java.util.Vector;

public class Cart implements Serializable {

    private User user;
    private Vector<Product> cartProducts;
    private boolean checkOut;

    public Cart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vector<Product> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(Vector<Product> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }
}
