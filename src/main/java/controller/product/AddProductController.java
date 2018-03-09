package controller.product;

import model.beans.Product;
import model.database.ProductOperation;
import model.interfaces.ProductOperationInterface;
import util.ValidationCheck;

public class AddProductController {
    
    ProductOperationInterface productOperation;

    public static final int PRODUCT_EXIST = 1;
    public static final int PRODUCT_ADDED = 2;
    public static final int INVALID_NAME = 3;

    public AddProductController() {
        productOperation = new ProductOperation();
    }

    public int addProduct(Product product)
    {
        int added;
        ValidationCheck validationCheck = new ValidationCheck();
       // if(!validationCheck.isName(product.getName()))
       // {
         //   added = INVALID_NAME;
       // }
       // else
       // {
          /* boolean exist = productOperation.isProductExist(product.getSku));
            if(!exist ){

                productOperation.addNewProduct(product);
                added=PRODUCT_ADDED;
            }
            else
            {
                added = PRODUCT_EXIST;
            }*/
            
            productOperation.addNewProduct(product);
            added=PRODUCT_ADDED;
        //}

       return added;
    }
    
    
    
}
