package controller.product;

import model.database.ProductOperation;
import model2.interfaces.ProductOperationInterface;

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
