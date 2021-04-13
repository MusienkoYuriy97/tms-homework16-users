package by.tms.dao;

import by.tms.entity.User;
import by.tms.exeptions.InputDataUserException;
import by.tms.exeptions.UserDataException;
import by.tms.exeptions.UserException;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao{
    private static List<User> users = new ArrayList<>();

    public List<User> getUsers() throws UserException {
        if (users.isEmpty()){
            throw new UserDataException("There are no registered users in the system!");
        }
        return users;
    }

    @Override
    public void saveUser(User user) throws UserException {
        if (users.contains(user)){
            throw new UserDataException("User already exist");
        }
        if (user.getUsername() == null || user.getPassword() == null){
            throw new InputDataUserException("Enter at least your username and password");
        }

        users.add(user);
    }
}
