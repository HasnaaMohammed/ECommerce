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
    private String query;
    private ResultSet resultSet;
    private User user = null;
    private Vector<User> vector = new Vector<>();

    public UserOperation() {
        databaseHandler = DatabaseHandler.getInstance();
    }

    @Override
    public User getUserbyEmail(String email) {

        try {
            query = "select * from User where email = '" + email + "'";
            resultSet = databaseHandler.select(query);
            fillObject();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean isUserExist(String email) {
        return getUserbyEmail(email.toLowerCase().trim()) != null ;
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
                query = "insert into User(Full_Name,password,email,birthDate,address,job,Credit_Limit,role) values('" + newUse.getFullName()
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
            fillObject();
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
            fillObject();
       } catch (SQLException ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public boolean updateUser(User user)
    {
        query = "UPDATE User SET Password = "+user.getPassword()+", Full_Name= "+user.getFullName()+
                ", Birthdate = "+user.getBirthDate() +", address = "+user.getAddress()+", Job = "+user.getJob() +
                ", Credit_Limit = "+user.getCredit()+" WHERE email = "+user.getEmail() +";";

        databaseHandler.update(query);

    }
    private void fillObject() throws SQLException {

        if (resultSet.next()) {

            String fullName = resultSet.getString("Full_Name");
            String useremail = resultSet.getString("email");
            String password = resultSet.getString("password");
            LocalDate birthDate =  resultSet.getDate("birthDate").toLocalDate();
            String address = resultSet.getString("address");
            String job = resultSet.getString("job");
            int credit = resultSet.getInt("credit_limit");
            int userRole = resultSet.getInt("role");
            user = new User(fullName,useremail,birthDate, address, job, credit, userRole  ,password);

            vector.add(user);

        }
    }


}
