package model.database;

import model.beans.Order;
import model.interfaces.OrderOperationInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OrderOperation implements OrderOperationInterface {

    private DatabaseHandler databaseHandler ;
    private ResultSet resultSet;
    public OrderOperation()
    {
        databaseHandler  = DatabaseHandler.getInstance();
    }
    @Override
    public void addCartToOrder(int cartID) {

    }

    @Override
    public Vector<Order> getAllOrders(String email)  {
        Vector<Order> orders = new Vector<>();
        String sql = "SELECT `Order`.`id`,\n" +
                "    `Order`.`Total_Price`,\n" +
                "    `Order`.`Cart_id`,\n" +
                "    `Order`.`Timestamp`\n" +
                "FROM `Order` , User , Cart\n" +
                "where User.Email = '"+email +
                "' and Cart.User_id = User.id\n" +
                "and `Order`.Cart_id = Cart.id and\n" +
                "Cart.Checkout = 1;";
        resultSet = databaseHandler.select(sql);
        try {
            while (resultSet.next())
            {
                Order order = new Order();

                    order.setId(resultSet.getInt(1));

                order.setPrice(resultSet.getDouble(2));
                order.setTimeStamp(resultSet.getDate(4).toLocalDate());
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(orders.size());
        return orders;
    }

    @Override
    public Vector<Order> getAllOrders() {
        Vector<Order> orders = new Vector<>();
        String sql = "SELECT `Order`.`id`,\n" +
                "    `Order`.`Total_Price`,\n" +
                "    `Order`.`Cart_id`,\n" +
                "    `Order`.`Timestamp`,\n" +
                "    `User`.`Full_Name`\n"+
                "FROM `Order` , User , Cart\n" +
                "where "+
                "Cart.User_id = User.id\n" +
                "and `Order`.Cart_id = Cart.id and\n" +
                "Cart.Checkout = 1;";
        resultSet = databaseHandler.select(sql);
        try {
            while (resultSet.next())
            {
                Order order = new Order();

                order.setId(resultSet.getInt(1));
                order.setPrice(resultSet.getDouble(2));
                order.setTimeStamp(resultSet.getDate(4).toLocalDate());
                order.setUserName(resultSet.getString(5));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("asmaaDB "+orders.size());
        return orders;
    }


}
