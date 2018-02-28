package model.database;

import model.beans.User;
import model.interfaces.UserOperationInterface;

import java.sql.ResultSet;
import java.util.Vector;

public class UserOperation implements UserOperationInterface {

    private DatabaseHandler databaseHandler;

    public UserOperation() {
        databaseHandler = DatabaseHandler.getInstance();
    }

    @Override
    public User getUserbyEmail(String email) {
        return null;
    }

    @Override
    public int addUser(User newUser) {
        return 0;
    }

    @Override
    public Vector<User> getUsers(int type) {
        return null;
    }

    @Override
    public Vector<User> getUsers() {
        return null;
    }

    public boolean isUserExist(String email) {

        return getUserbyEmail(email.toLowerCase().trim()) != null;
    }
}
