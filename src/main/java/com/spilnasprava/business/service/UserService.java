package com.spilnasprava.business.service;

import com.spilnasprava.entity.mysql.User;
import com.spilnasprava.entity.mysql.UserKey;
import com.spilnasprava.entity.postgresql.Area;

import java.util.List;

/**
 * Create Service interface to work with the User
 */
public interface UserService {
    public List<User> getAllUser();
    public void addUser(User user);

}
