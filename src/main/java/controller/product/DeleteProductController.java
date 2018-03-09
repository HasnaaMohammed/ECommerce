package controller.product;

import model.beans.Product;
import model.database.ProductOperation;
import model.interfaces.ProductOperationInterface;
import util.ValidationCheck;

public class DeleteProductController {
    
    ProductOperationInterface productOperation;


    public DeleteProductController() {
        productOperation = new ProductOperation();
    }

    public boolean deleteProduct(int sku)
    {
     
        System.out.println("delete product controller - delete product");
        boolean deleted;

        deleted= productOperation.deleteProduct(sku);

       return deleted;
    }
    
    
    
}
