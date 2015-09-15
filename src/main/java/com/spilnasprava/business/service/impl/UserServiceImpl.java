package com.spilnasprava.business.service.impl;

import com.spilnasprava.business.dao.UserDAO;
import com.spilnasprava.business.service.UserService;
import com.spilnasprava.entity.mysql.User;
import com.spilnasprava.entity.mysql.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUser(){
        return userDAO.getAllUser();
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
