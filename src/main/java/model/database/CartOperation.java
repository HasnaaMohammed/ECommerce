package model.database;

import model.beans.Cart;
import model.beans.Product;
import model.beans.User;
import model.interfaces.CartOperationInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CartOperation implements CartOperationInterface {


    private Cart cart;
    private Product product;
    private DatabaseHandler databaseHandler;
    private Vector<Product> productVector;
    private String query;
    private ResultSet resultSet;

    public CartOperation()
    {
        databaseHandler = DatabaseHandler.getInstance();
    }
    @Override
    public Cart getUserUnpaidCart(String email) {
       return null;
    }

    @Override
    public Vector<Cart> getUserpaidCart(String email) {
        return null;
    }

    public int getUserCartID(String email){
        int cart_id = -1;
        try {

            query = "select Cart.id from Cart , User " +
                    " where User.Email = '"+ email +
                    "' and Cart.User_id = User.id " +
                    " and Cart.Checkout = 0 ";
            resultSet = databaseHandler.select(query);

            if (resultSet.next()) {
                cart_id =  resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart_id;
    }

    @Override
    public int createUserCart(String email) {
        String sql = "INSERT INTO `ECommerce`.`Cart` (`User_id`, `Checkout`) " +
                "VALUES ((select User.id from User where User.email = '"+email+"'), '0')";
        if(databaseHandler.update(sql))
        {
            return getUserCartID(email);
        }
        else
            return -1;

    }


    @Override
    public boolean productInCart(int cartID, int productID)  {
        String sql = "select id from Cart_product where Product_id = "+productID+" and Cart_id = "+cartID+";";
        resultSet = databaseHandler.select(sql);
        try {
            if (resultSet.next()) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateProductCartQuantity(int cartID, int productID, int quantity) {
        String sql = "UPDATE ECommerce.Cart_product SET Quantity='2' WHERE Product_id= "+productID+ " and Cart_id = "+cartID+";";
        databaseHandler.update(sql);

    }

    @Override
    public void addProductToCart(int cartID, int productID, int quantity) {
        String sql ="INSERT INTO `ECommerce`.`Cart_product` (`Product_id`, `Cart_id`, `Quantity`) VALUES ("+productID+","+cartID+","+quantity+");";
        databaseHandler.update(sql);
    }


    private void fillObject() throws SQLException {
        if (resultSet.next()) {
            String name = resultSet.getString("Name");
            int quantity = resultSet.getInt("Quantity");
            double price = resultSet.getDouble("price");
            String prodect_img = resultSet.getString("prodect_img");
            String category_id = resultSet.getString("category_id");
//            product = new Product(name,quantity,price,prodect_img,category_id);

        }
    }
}
