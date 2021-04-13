package by.tms.dao;

import by.tms.entity.User;
import by.tms.exeptions.UserException;

import java.util.List;

public interface UserDao {
    List<User> getUsers() throws UserException;
    void saveUser(User user) throws UserException;
}
