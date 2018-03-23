package controller.product;

import model2.interfaces.ProductOperationInterface;

public class CategoryController {

    ProductOperationInterface productOperation;

    public CategoryController(ProductOperationInterface productOperation) {
        this.productOperation = productOperation;
    }

}
