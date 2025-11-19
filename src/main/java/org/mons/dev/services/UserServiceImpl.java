package org.mons.dev.services;

import org.mons.dev.DAO.user.UserOrmImpl;
import org.mons.dev.models.User;

public class UserServiceImpl {
    UserOrmImpl userDaoService = new UserOrmImpl();


    public boolean validate(String username, String password){
        User user = userDaoService.getUser(username);
        return user.getPassword().equals(password);
    }


}
