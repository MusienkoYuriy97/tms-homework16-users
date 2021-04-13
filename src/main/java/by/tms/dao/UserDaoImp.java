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
        return new ArrayList<>(users);
    }

    @Override
    public void saveUser(User user) throws UserException {
        users.add(user);
    }
}
