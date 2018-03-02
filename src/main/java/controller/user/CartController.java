package controller.user;

import model.beans.Cart;
import model.beans.Product;
import model.beans.User;
import model.database.DatabaseHandler;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;


public class CartController{

    private Cart cart;
    private Product product;
    private DatabaseHandler databaseHandler;
    private Vector<Product> productVector;
    private String query;
    private ResultSet resultSet;
    private  int user_id;
    private  int cart_id;
    private  int checkout;

    public  void getProdect(int id){
         try {

        query = "select * from Product where id = '" + id + "'";
        resultSet = databaseHandler.select(query);
        fillObject();
       } catch (SQLException e) {
        e.printStackTrace();
      }
}
    public  void getuser_id(){
        try {
            User user=cart.getUser();
            query = "select  id from User where email = '" +  user.getEmail()+ "'";
            resultSet = databaseHandler.select(query);
            if (resultSet.next()) {
                user_id =  resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  void getCart_id(){
        try {
         User user=cart.getUser();
         query = "select  id from User where email = '" +  user.getEmail()+ "'";
         resultSet = databaseHandler.select(query);
            if (resultSet.next()) {
               cart_id =  resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public  void getCart_Checkout(){
      try {
          query = "select  checkout from cart where user_id = '" + user_id + "'";
          resultSet = databaseHandler.select(query);

          if (resultSet.next()) {
               checkout = resultSet.getInt("checkout");
               if(checkout==0)
                   cart.setCheckOut(false);
               else
                   cart.setCheckOut(true);
          }
          if(!cart.isCheckOut()){
              productVector.add(product);
              cart.setCartProducts(productVector);
          }
      }catch (SQLException e) {
          e.printStackTrace();
      }

    }




    private void fillObject() throws SQLException {
        if (resultSet.next()) {
            String name=resultSet.getString("Name");
            int quantity=resultSet.getInt("Quantity");
            double price=resultSet.getDouble("price");
            String prodect_img=resultSet.getString("prodect_img");
            String category_id=resultSet.getString("category_id");
            product = new Product(name,quantity,price,prodect_img,category_id);

        }
    }







}
