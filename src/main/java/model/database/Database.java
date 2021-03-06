package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {


    private Connection connection ;
    private Database(){connect();}
    private static Database instance;
    public static Database getInstance()
    {
        if(instance == null)
            instance = new Database();
        return instance;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://104.154.93.46:3306/ECommerce";
//            String dbUrl = "jdbc:mysql://127.0.0.1:3306/ECommerce";
            connection = DriverManager.getConnection(dbUrl, "root", "##HelloWorld##");
//            connection = DriverManager.getConnection(dbUrl, "root", "root");

            System.out.println("connection succeeded");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        return connection;
    }
}
