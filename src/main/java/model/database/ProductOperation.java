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


    public ProductOperation() {
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
                query = "insert into Product(Name,Quantity,Sku,price,product_img,category_id) values('" + product.getName()
                        + "','" + product.getQuantiity() + "','" + product.getSku() + "','"+ product.getPrice()
                        + "','" + product.getProduct_img() + "','" +
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
    public Product getProductInfo(int sku) {
        try {
            query = "SELECT Product.id,\n" +
                    "    Product.Name,\n" +
                    "    Product.Quantity,\n" +
                    "    Product.Sku,\n" +
                    "    Product.Price,\n" +
                    "    Product.Product_img,\n" +
                    "    Category.Category_name\n" +
                    "from ECommerce.Product , ECommerce.Category\n" +
                    "where Sku = " + sku + " and Category.id = Product.Category_id;";
            resultSet = databaseHandler.select(query);
            if (resultSet.next()) {
                int productID = resultSet.getInt(1);
                String name = resultSet.getString("Name");
                sku = resultSet.getInt("sku");
                int quantity = resultSet.getInt("Quantity");
                double price = resultSet.getDouble("price");
                String product_img = resultSet.getString("product_img");
                String category = resultSet.getString("Category_name");
                product = new Product(productID, name, sku, quantity, price, product_img, category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    @Override
    public Vector<Category> getAllCategoriesWithProducts() {
        Vector<Category> categories = new Vector<>();

        try {
            Vector<String> categoriesQuery = getAllCategories();
            for (String categorys : categoriesQuery) {
                Category category = new Category();
                category.setName(categorys);
                category.setProducts(getCategoryProducts(categorys));
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
    @Override
    public Vector<Product> getCategoryProducts(String category) throws SQLException {
        Vector<Product> products = new Vector<>();

        String query = "select " +
                "    `Product`.`Name`,\n" +
                "    `Product`.`Quantity`,\n" +
                "    `Product`.`Sku`,\n" +
                "    `Product`.`Price`,\n" +
                "    `Product`.`Product_img`,\n" +
                "    `Product`.`Category_id`\n" +
                " from Product , Category\n" +
                " where Category.Category_name = '" + category +
                "'  and Product.Category_id = Category.id" +
                " and Quantity > 0; ";
        resultSet = databaseHandler.select(query);
        getproduct(category, products);
        return products;
    }
    @Override
    public Vector<Product> getCategoryProductswithPrice(String category, double minPrice, double maxPrice) throws SQLException {
        Vector<Product> products = new Vector<>();

        String query = "select " +
                "    `Product`.`Name`,\n" +
                "    `Product`.`Quantity`,\n" +
                "    `Product`.`Sku`,\n" +
                "    `Product`.`Price`,\n" +
                "    `Product`.`Product_img`,\n" +
                "    `Product`.`Category_id`\n" +
                " from Product , Category\n" +
                " where Category.Category_name = '" + category +
                "'  and Product.Category_id = Category.id" +
                " and Quantity > 0 and price between (" + minPrice + "," + maxPrice + ");";
        resultSet = databaseHandler.select(query);
        getproduct(category, products);
        return products;
    }

    private void getproduct(String category, Vector<Product> products) throws SQLException {
        while (resultSet.next()) {
            Product product = new Product();
            product.setName(resultSet.getString(1));
            product.setQuantiity(resultSet.getInt(2));
            product.setSku(resultSet.getInt(3));
            product.setPrice(resultSet.getDouble(4));
            product.setProduct_img(resultSet.getString(5));
            product.setProduct_category(category);
            products.add(product);
        }
    }
}
