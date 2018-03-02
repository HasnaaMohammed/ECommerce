package model.interfaces;

import model.beans.Cart;
import model.beans.Product;
import model.beans.User;

public interface ProductOperationInterface {



    public boolean addNewProduct(Product product);
    public boolean addNewCategory(String category);
    public Product getProductInfo(String id);



}
