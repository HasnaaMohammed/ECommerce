package model2.interfaces;

import model.beans.User;

import java.util.Vector;

public interface UserOperationInterface {

    public User getUserbyEmail(String email);
    public boolean isUserExist(String email);
    public int addUser(User newUser);
    public Vector<User> getUsers(int type);
    public boolean updateUser(User user);
}
