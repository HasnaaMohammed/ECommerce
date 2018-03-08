package model.beans;

import java.io.Serializable;
import java.util.Vector;

public class Cart implements Serializable {

    private int cartID;
    private Vector<Product> cartProducts;
    private boolean checkOut;

    public Cart() {
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
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
