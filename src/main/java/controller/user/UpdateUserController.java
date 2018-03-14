package controller.user;

import model.beans.User;
import model.database.UserOperation;
import util.ValidationCheck;

public class UpdateUserController {

    private User user ;
    private ValidationCheck validationCheck ;
    private UserOperation userOperation ;
    public UpdateUserController()
    {
        validationCheck = new ValidationCheck();
        userOperation = new UserOperation();
    }
    public void setUser(User user)
    {
        this.user = user;
    }

    private boolean validateData()
    {
        return validationCheck.isValidLimit(user.getCredit());
    }

    public boolean updateUserData() {
        return validateData() && userOperation.updateUser(user);
    }

    public double getUserLimit(String email){
        return userOperation.getUserCurrentCredit(email);
    }
}
