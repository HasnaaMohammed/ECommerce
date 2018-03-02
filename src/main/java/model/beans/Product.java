package model.beans;

public class Product {

    private String name;
    private int quantiity;
    private double price;
    private String product_img;
    private String product_category;

    public Product() {
    }

    public Product(String name, int quantiity, double price, String product_img, String product_category) {
        this.name = name;
        this.quantiity = quantiity;
        this.price = price;
        this.product_img = product_img;
        this.product_category = product_category;
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
}
