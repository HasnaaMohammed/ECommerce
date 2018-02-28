package controller.user;

import java.time.LocalDate;
import model.beans.User;
import model.interfaces.UserOperationInterface;

public class RegisterController {
    
    UserOperationInterface userOperation;

    public UserOperationInterface getUserOperation() {
        return userOperation;
    }

    public boolean registerUser(String fullName, String email, String job, String address, LocalDate birthDate)
    {
        boolean registered = false;
        boolean exist = userOperation.isUserExist(email);
        if(!exist){
            User user = new User();
            user.setFullName(fullName);
            user.setEmail(email);
            user.setJob(job);
            user.setAddress(address);
            user.setBirthDate(birthDate);
            userOperation.addUser(user);
            registered=true;
        }
        
       return registered;
    }
    
    
    
}
