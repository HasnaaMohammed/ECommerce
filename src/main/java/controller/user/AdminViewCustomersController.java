/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.util.Vector;
import model.beans.User;
import model.database.UserOperation;
import model2.interfaces.UserOperationInterface;

/**
 *
 * @author Asmaa
 */
public class AdminViewCustomersController {
    private UserOperationInterface userOperationInterface;
    private Vector<User> userList;// = new Vector<User>();
    
    public Vector<User> getCustomerList(){
        userOperationInterface=new UserOperation();
        userList=userOperationInterface.getUsers(0);
        return userList;
    }
    
}
