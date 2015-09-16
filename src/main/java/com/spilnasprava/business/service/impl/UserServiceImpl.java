package com.spilnasprava.business.service.impl;

import com.spilnasprava.business.dao.UserDAO;
import com.spilnasprava.business.service.UserService;
import com.spilnasprava.entity.mysql.User;
import com.spilnasprava.entity.mysql.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implements interface Service @see com.spilnasprava.business.service.UserService
 */
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    /**
     * Get list User from database.
     *
     * @return list User
     */
    public List<User> getAllUser(){
        return userDAO.getAllUser();
    }

    /**
     * Save User in DB.
     *
     * @param user
     */
    public long addUser(User user) {
        return userDAO.addUser(user);
    }
}
