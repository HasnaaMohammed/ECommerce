
package model.database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asmaa
 */
public class DatabaseHandler {
    private static DatabaseHandler databaseHandler;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement pres;
   
    private DatabaseHandler() {
        connect();
       
    }
    public static DatabaseHandler getInstance(){
        if(databaseHandler==null)
            databaseHandler=new DatabaseHandler();
        
        return databaseHandler;
    }

    private void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://35.202.50.71:3306/ECommerce";
			connection = DriverManager.getConnection(dbUrl, "mfawzy", "\\c3d{kBj\\8UqUAny");
            System.out.println("connection succeeded");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void insert(String query){
        try {
            pres = connection.prepareStatement(query);
            pres.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(String query){
        try {
            pres = connection.prepareStatement(query);
            pres.executeUpdate();
            //statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(String query){
        try {
            pres = connection.prepareStatement(query);
            pres.executeUpdate();
            //statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet select(String query){
        
        try {
            pres = connection.prepareStatement(query);
            resultSet = pres.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    public void closeConnection(){
        try {
            connection.close();
            databaseHandler=null;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
