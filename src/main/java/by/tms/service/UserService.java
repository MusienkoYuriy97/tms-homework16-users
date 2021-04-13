package by.tms.service;

import by.tms.dao.UserDao;
import by.tms.dao.UserDaoImp;
import by.tms.entity.User;
import by.tms.exeptions.*;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDaoImp();

    public void addUser(String username, String fname,String lname, int age, String password) throws UserException {
        userDao.saveUser(new User(username,fname,lname,age,password));
    }

    public List<User> getUsers() throws UserException {
        return userDao.getUsers();
    }

    public void signIn(String username, String password) throws UserException {
        if (username == null || password == null){
            throw new InputDataUserException("Sign in with both your password and username");
        }
        boolean userIsExist = false;
        for (User user : userDao.getUsers()) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
                userIsExist = true;
                break;
            }
        }
        if (!userIsExist){
            throw new InputDataUserException("Wrong username or password");
        }
    }
}
