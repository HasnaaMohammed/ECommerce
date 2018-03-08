package controller.user;

import java.time.LocalDate;
import model.beans.User;
import model.database.UserOperation;
import model.interfaces.UserOperationInterface;
import util.ValidationCheck;

public class RegisterController {
    
    UserOperationInterface userOperation;

    public static final int USER_EXIST = 1;
    public static final int USER_REGISTERED = 2;
    public static final int INVALID_EMAIL = 3;

    public RegisterController() {
        userOperation = new UserOperation();
    }

    public int registerUser(User user)
    {
        int registered;
        ValidationCheck validationCheck = new ValidationCheck();
        if(!validationCheck.isEmail(user.getEmail()) || !validationCheck.isEmptyString(user.getPassword())
                || !validationCheck.isValidLimit(user.getCredit()))
        {
            registered = INVALID_EMAIL;
        }
        else
        {
            boolean exist = userOperation.isUserExist(user.getEmail());
            if(!exist ){

                userOperation.addUser(user);
                registered=USER_REGISTERED;
            }
            else
            {
                registered = USER_EXIST;
            }
        }

       return registered;
    }
    
    
    
}
