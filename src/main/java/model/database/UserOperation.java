package model.database;

import model.beans.User;
import model.interfaces.UserOperationInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserOperation implements UserOperationInterface {

    private DatabaseHandler databaseHandler;
    String query;
    ResultSet resultSet;
    User user = null;
    Vector<User> vector = new Vector<>();

    public UserOperation() {
        databaseHandler = DatabaseHandler.getInstance();
    }

    @Override
    public User getUserbyEmail(String email) {

        try {
            query = "select * from User where email = '" + email + "'";
            resultSet = databaseHandler.select(query);
            if (resultSet.next()) {

                String fullName = resultSet.getString("fullName");
                String password = resultSet.getString("password");
                String ueremail = resultSet.getString("email");
                LocalDate birthDate = resultSet.getDate("birthDate").toLocalDate();
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                int credit = resultSet.getInt("credit_limit");
                int role = resultSet.getInt("role");
                user = new User(fullName, password,ueremail, birthDate, address, job, credit, role);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public int addUser(User newUse) {
        try {
            query = "select * from USER where user_name = '" + newUse.getEmail() + "'";
            resultSet = databaseHandler.select(query);

            if (resultSet.next()) {
                databaseHandler.closeConnection();
                return 1;  //user already exist
            } else {
                query = "insert into User(fullName,password,email,birthDate,address,job,credit,role) values('" + newUse.getFullName()
                        + "','" +newUse.getPassword() +"','" + newUse.getEmail() + "','" + newUse.getBirthDate() + "','" + newUse.getAddress() + "','" + newUse.getJob() + "','"
                        + newUse.getCredit() + "','" + newUse.getRole() + "')";

                databaseHandler.insert(query);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; //user is new
    }

    @Override
    public Vector<User> getUsers(int role) {
        try {
            query = "select * from User where role = '" + role + "'";
            resultSet = databaseHandler.select(query);
            if (resultSet.next()) {

                String fullName = resultSet.getString("fullName");
                String ueremail = resultSet.getString("email");
                String password = resultSet.getString("password");
                LocalDate birthDate =  resultSet.getDate("birthDate").toLocalDate();
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                int credit = resultSet.getInt("credit_limit");
                int userrole = resultSet.getInt("role");
                user = new User(fullName, password, ueremail,birthDate, address, job, credit, userrole);

                vector.add(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    @Override
    public Vector<User> getUsers() {
       try {
            query = "select * from User";
            resultSet = databaseHandler.select(query);
            if (resultSet.next()) {

                String fullName = resultSet.getString("fullName");
                String ueremail = resultSet.getString("email");
                String password = resultSet.getString("password");
                LocalDate birthDate =  resultSet.getDate("birthDate").toLocalDate();
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                int credit = resultSet.getInt("credit_limit");
                int userrole = resultSet.getInt("role");
                user = new User(fullName, password, ueremail,birthDate, address, job, credit, userrole);

                vector.add(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
}
