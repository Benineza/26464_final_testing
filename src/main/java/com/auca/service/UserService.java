package com.auca.service;

import com.auca.dao.UserDao;
import com.auca.domain.User;

public class UserService {

    private final UserDao userDao = new UserDao();
    public boolean authenticate(String username, String rawPassword){
        if (username == null || username.isBlank() || rawPassword == null || rawPassword.isBlank()){
            return false;
        }

        User user = userDao.findByUsername(username);
        if (user == null){
            return false;
        }
        return user.getPassword().equals(rawPassword);
    }
}