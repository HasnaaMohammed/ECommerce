package model.database;

import model.beans.User;
import model2.adapter.EntityAdapter;
import model2.doa.UserDao;
import model2.entity.UserEntity;
import model2.interfaces.UserOperationInterface;

import javax.swing.text.html.parser.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserOperation implements UserOperationInterface {

    private DatabaseHandler databaseHandler;
    private String query;
    private ResultSet resultSet;
    private User user = null;
    private Vector<User> vector = new Vector<>();

    private UserDao userDao ;
    public UserOperation() {

        databaseHandler = DatabaseHandler.getInstance();
        userDao = UserDao.getInstance();
    }
    //Converted
    @Override
    public User getUserbyEmail(String email) {
        String userQuery = "select u from UserEntity u where u.email = '"+email+"'";
        List<UserEntity> userEntity = userDao.select(userQuery);
        if(userEntity != null && userEntity.size() > 0)
        {
            User user = EntityAdapter.userAdapter(userEntity.get(0));
            return user;
        }
        else return null;


    }
    //Converted
    @Override
    public boolean isUserExist(String email) {
        return getUserbyEmail(email.toLowerCase().trim()) != null ;
    }
    //Converted
    @Override
    public int addUser(User user) {

        String userQuery = "select u from UserEntity u where u.email = '"+user.getEmail()+"'";
        List list = userDao.select(userQuery);
        if(list ==  null || list.size()> 0 )
            return 1;
        else{
            UserEntity userEntity = new UserEntity();
            userEntity.setAddress(user.getAddress());
            userEntity.setEmail(user.getEmail());
            userEntity.setPassword(user.getPassword());
            userEntity.setFullName(user.getFullName());
            userEntity.setBirthdate(Date.from(user.getBirthDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            userEntity.setJob(user.getJob());
            userEntity.setCreditLimit(user.getCredit());
            userEntity.setRole((byte)user.getRole());
            userDao.insert(userEntity);
            return 0;
        }

    }
    //Converted
    @Override
    public Vector<User> getUsers(int role) {
        String userQuery = "select u from UserEntity u where u.role = "+role;
        List<UserEntity> userEntities = userDao.select(userQuery);
        Vector<User> users = new Vector<>();
        for(UserEntity userEntity : userEntities)
        {
            users.add(EntityAdapter.userAdapter(userEntity));
        }

        return users;
    }
    //Converted
    public boolean updateUser(User user) {
        String userQuery = "select u from UserEntity u where u.email = '"+user.getEmail()+"'";
        List<UserEntity> userEntity = userDao.select(userQuery);
        if(userEntity != null && userEntity.size() > 0)
        {
            UserEntity userEntity1 = userEntity.get(0);
            userEntity1.setPassword(user.getPassword());
            userEntity1.setFullName(user.getFullName());
            userEntity1.setBirthdate(Date.from(user.getBirthDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            userEntity1.setAddress(user.getAddress());
            userEntity1.setJob(user.getJob());
            userEntity1.setCreditLimit(user.getCredit());
            userDao.update(userEntity1);
            return true;
        }
        return false;

    }
    //Converted
    public double getUserCurrentCredit(String email) {
       User user = getUserbyEmail(email);
       if(user != null)
       {
           return user.getCredit();
       }
       else
           return 0.0;
    }



}
