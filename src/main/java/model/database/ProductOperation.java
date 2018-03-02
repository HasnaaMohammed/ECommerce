package model.database;

import model.beans.Product;
import model.interfaces.ProductOperationInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductOperation implements ProductOperationInterface {
    private DatabaseHandler databaseHandler;
    private String query;
    private ResultSet resultSet;
     private Product product  = null;

    @Override
    public boolean addNewProduct(Product product) {
        try {
            query = "select * from Product where sku = '" + product.getSku() + "'";
            resultSet = databaseHandler.select(query);
            if (resultSet.next()) {
                databaseHandler.closeConnection();
                return false;
            } else {
                query = "insert into Product(Name,Quantity,price,product_img,category_id) values('" + product.getName()
                        + "','" + product.getQuantiity() + "','" + product.getPrice() + "','" + product.getProduct_img() + "','" +
                        product.getProduct_category() + "')";

                databaseHandler.insert(query);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public boolean addNewCategory(String category) {
        try {
            query = "select * from Category where Category_name = '" + category + "'";
            resultSet = databaseHandler.select(query);
            if (resultSet.next()) {
                databaseHandler.closeConnection();
                return false;
            } else {
                query = "insert into Category(Category_name) values('" + category + "')";
                databaseHandler.insert(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public Product getProductInfo(String id) {
        try {
            query = "select * from Product where id = '" + id + "'";
            resultSet = databaseHandler.select(query);

            if (resultSet.next()) {

                String name = resultSet.getString("Name");
                int sku = resultSet.getInt("sku");
                int quantity = resultSet.getInt("Quantity");
                double price = resultSet.getDouble("price");
                String product_img = resultSet.getString("product_img");
                String category = resultSet.getString("category_id");

                product = new Product(name, sku, quantity, price, product_img, category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }
}
