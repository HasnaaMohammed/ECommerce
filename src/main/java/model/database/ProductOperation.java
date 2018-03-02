package model.database;

import model.beans.Product;
import model.interfaces.ProductOperationInterface;

public class ProductOperation implements ProductOperationInterface {

    @Override
    public boolean addNewProduct(Product product) {
        return false;
    }

    @Override
    public boolean addNewCategory(String category) {
        return false;
    }

    @Override
    public String getProductInfo(String id) {
        return null;
    }
}
