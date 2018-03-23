package model2.interfaces;

import model.beans.Cart;
import model2.entity.CartEntity;

import java.util.Vector;

public interface CartOperationInterface {

    public CartEntity getCartByID(int id);
    public Cart getUserUnpaidCart(String email);
    public int getUserCartID(String email);
    public int createUserCart(String email);
    public boolean productInCart(int cartID, int productID)  ;
    public void updateProductCartQuantity(int cartID , int productID , int quantity);
    public void addProductToCart(int cartID , int productID , int quantity);
    public boolean removeProductFromCart(int cartID , int ProductID);
    public boolean finalizeCart(int cartID);
}
