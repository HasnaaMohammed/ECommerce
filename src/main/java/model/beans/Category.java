package model.beans;

import java.io.Serializable;
import java.util.Vector;

public class Category  implements Serializable {

    private String name;
    private Vector<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Product> getProducts() {
        return products;
    }

    public void setProducts(Vector<Product> products) {
        this.products = products;
    }
}
