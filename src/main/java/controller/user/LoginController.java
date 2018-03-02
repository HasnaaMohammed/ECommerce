package controller.user;

import model.beans.User;
import model.database.UserOperation;
import model.interfaces.UserOperationInterface;

public class LoginController {
    
    private UserOperationInterface userOperation;
    private User userObject ;
    public static final String USER_DATA = "loggedUserData";

    public LoginController() {
        userOperation = new UserOperation();
    }

    public boolean getUserValidation(String email, String password)
    {
        boolean verified = false;
        User user = userOperation.getUserbyEmail(email.toLowerCase().trim());

        if(user != null && user.getPassword().equals(password))
        {
            verified=true;
            userObject = user;
        }
        return verified;
    }

    public User getUserObject()
    {
        return userObject;
    }
}
