package com.spilnasprava.business.dao;

import com.spilnasprava.entity.mysql.User;
import com.spilnasprava.entity.mysql.UserKey;
import com.spilnasprava.entity.postgresql.Area;

import java.util.List;

/**
 * Create DAO interface to work with the User
 */
public interface UserDAO {
    List<User> getAllUser();
    void addUser(User user);

    }
