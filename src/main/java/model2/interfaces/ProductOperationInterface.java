package model2.interfaces;

import model.beans.Category;
import model.beans.Product;
import model2.entity.ProductEntity;

import java.sql.SQLException;
import java.util.Vector;

public interface ProductOperationInterface {



    public boolean addNewProduct(Product product);
    public ProductEntity getProductByID(int id);
    public boolean addNewCategory(String category);
    public Product getProductInfo(int id);
    public Vector<Category> getAllCategoriesWithProducts();
    public Vector<String> getAllCategories() throws SQLException;
    public Vector<Product> getCategoryProducts(String category) throws SQLException;
    public Vector<Product> getCategoryProducts(String category , int index) throws SQLException ;
    public Vector<Product> getCategoryProductswithPrice(String category, double minPrice, double maxPrice) throws SQLException;
    public boolean decreaseQuantity(int productID , int quantity);
    public boolean editProduct(Product product);
    public boolean deleteProduct(int sku);

}
