package model.interfaces;

import model.beans.Cart;
import model.beans.Product;
import model.beans.User;

import java.sql.SQLException;
import java.util.Vector;

public interface CartOperationInterface {


    public Cart getUserUnpaidCart(String email);
    public Vector<Cart> getUserpaidCart(String email);
    public int getUserCartID(String email);
    public int createUserCart(String email);
    public boolean productInCart(int cartID, int productID)  ;
    public void updateProductCartQuantity(int cartID , int productID , int quantity);
    public void addProductToCart(int cartID , int productID , int quantity);
    public void getCartTotalPrice(int cartID);
}
