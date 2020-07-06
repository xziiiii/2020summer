package com.example.bx_web.service;

import com.example.bx_web.dao.UserDao;
import com.example.bx_web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User userLogin(User user) {
        user = userDao.userLogin(user.getUsername(), user.getPassword());
        return user;
    }
}
