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

        Database database = Database.getInstance();
        connection = database.getConnection();
    }

    public static DatabaseHandler getInstance() {
        if (databaseHandler == null) {
            databaseHandler = new DatabaseHandler();
        }

        return databaseHandler;
    }



    public boolean insert(String query) {
        return executeNonQuery(query);
    }

    public boolean update(String query) {
        return executeNonQuery(query);
    }

    public boolean delete(String query) {
        return executeNonQuery(query);
    }

    private boolean executeNonQuery(String query) {
        try {
            pres = connection.prepareStatement(query);
            pres.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ResultSet select(String query) {

        try {
            pres = connection.prepareStatement(query);
            resultSet = pres.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    public void closeConnection() {
        try {
            connection.close();
            databaseHandler = null;
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
