package controller.product;

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
        return false;
    }

    public boolean isProductAvailable(int productSKU , int quantity){
        return productOperation.getProductInfo(productSKU).getQuantiity() >= quantity ;
    }

    public Product getProduct(int productSKU) {
       return productOperation.getProductInfo(productSKU);
    }


}
