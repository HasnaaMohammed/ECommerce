package model.beans;

import java.io.Serializable;

public class Product implements Serializable {

    private int productID;
    private String name;
    private int sku;
    private int quantiity;
    private double price;
    private String product_img;
    private String product_category;

    public Product() {
    }

//    public Product(String name, int sku, int quantiity, double price, String product_img, String product_category) {
//        this.name = name;
//        this.sku = sku;
//        this.quantiity = quantiity;
//        this.price = price;
//        this.product_img = product_img;
//        this.product_category = product_category;
//    }


    public Product(int productID, String name, int sku, int quantiity, double price, String product_img, String product_category) {
        this.productID = productID;
        this.name = name;
        this.sku = sku;
        this.quantiity = quantiity;
        this.price = price;
        this.product_img = product_img;
        this.product_category = product_category;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantiity() {
        return quantiity;
    }

    public void setQuantiity(int quantiity) {
        this.quantiity = quantiity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

}
