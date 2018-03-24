package controller.product;

import model.beans.Product;
import model.database.ProductOperation;
import model2.interfaces.ProductOperationInterface;

public class EditProductController {
    
    ProductOperationInterface productOperation;


    public EditProductController() {
        productOperation = new ProductOperation();
    }

    public boolean editProduct(Product product)
    {
     
        System.out.println("edit product controller - edit product");
        boolean updated;

        updated = productOperation.editProduct(product);

       return updated;
    }
    
    
    
}
