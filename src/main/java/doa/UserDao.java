package doa;

import model.beans2.UserEntity;
import model.interfaces.DaoInterface;

import java.util.List;

public class UserDao  implements DaoInterface<UserEntity> {
    @Override
    public void persist(UserEntity entity) {

    }

    @Override
    public void update(UserEntity entity) {

    }

    @Override
    public UserEntity select(String id) {
        return null;
    }

    @Override
    public void delete(UserEntity entity) {

    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
