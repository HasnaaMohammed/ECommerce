package controller.user;

import model.beans.User;
import model.interfaces.UserOperationInterface;

public class LoginController {
    
    public UserOperationInterface userOperation;
    public boolean getUserValidation(String email, String password)
    {
        boolean verified = false;
        User user = userOperation.getUserbyEmail(email);
        if(user.getPassword().equals(password))
        {
            verified=true;
        }
        return verified;
    }
}
