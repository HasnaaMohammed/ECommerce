package model.database;

import model.beans.Category;
import model.beans.Product;
import model.interfaces.ProductOperationInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductOperation implements ProductOperationInterface {
    private DatabaseHandler databaseHandler;
    private String query;
    private ResultSet resultSet;
    private Product product = null;


    public ProductOperation(){
        databaseHandler = DatabaseHandler.getInstance();

            }
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

    @Override
    public Vector<Category> getAllCategoriesWithProducts()  {
        Vector<Category> categories = new Vector<Category>();

        try {
            Vector<String> categoriesQuery = getAllCategories();
            for (String categorys : categoriesQuery) {
                Category category = new Category();
                category.setName(categorys);
                category.setProducts(getCategoryProduct(categorys));
                categories.add(category);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Vector<String> getAllCategories() throws SQLException {
        String query = "select * from Category;";
        resultSet = databaseHandler.select(query);
        Vector<String> result = new Vector<>();
        while (resultSet.next()) {
            result.add(resultSet.getString(2));
        }
        return result;
    }


    public Vector<Product> getCategoryProduct(String category) throws SQLException {
        Vector<Product> products = new Vector<>();
        Product product = new Product();
        String query = "select "+
                "    `Product`.`Name`,\n" +
                "    `Product`.`Quantity`,\n" +
                "    `Product`.`Sku`,\n" +
                "    `Product`.`Price`,\n" +
                "    `Product`.`Product_img`,\n" +
                "    `Product`.`Category_id`\n" +
                " from Product , Category\n" +
                " where Category.Category_name = '"+category+
                "'  and Product.Category_id = Category.id;";
        resultSet = databaseHandler.select(query);
        while(resultSet.next())
        {
            product.setName(resultSet.getString(1));
            product.setQuantiity(resultSet.getInt(2));
            product.setSku(resultSet.getInt(3));
            product.setPrice(resultSet.getDouble(4));
            product.setProduct_img(resultSet.getString(5));
            product.setProduct_category(category);
            products.add(product);
        }
        return products;
    }



}
