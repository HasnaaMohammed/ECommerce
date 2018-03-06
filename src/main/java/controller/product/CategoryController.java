package controller.product;

import model.interfaces.ProductOperationInterface;

public class CategoryController {

    ProductOperationInterface productOperation;

    public CategoryController(ProductOperationInterface productOperation) {
        this.productOperation = productOperation;
    }

}
