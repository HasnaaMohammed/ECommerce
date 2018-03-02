package controller.user;

import model.beans.Product;
import model.database.ProductOperation;
import model.interfaces.ProductOperationInterface;

public class ProductController {

    ProductOperationInterface productOperation;

    public ProductController(){
        productOperation = new ProductOperation();
    }

    public boolean addNewProduct(Product product)
    {

    }




}
