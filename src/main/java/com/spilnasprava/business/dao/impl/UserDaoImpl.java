package com.spilnasprava.business.dao.impl;

import com.spilnasprava.business.dao.utils.SeesionBaseInit;
import com.spilnasprava.business.dao.UserDAO;
import com.spilnasprava.entity.mysql.User;
import com.spilnasprava.entity.mysql.UserKey;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements interface DAO @see com.spilnasprava.business.dao.UserDAO
 */
public class UserDaoImpl extends SeesionBaseInit implements UserDAO {

    /**
     * Get list User from database.
     *
     * @return list User
     */
    public List<User> getAllUser() {
        Session session = getSessionMySQL();
        List<User> userList = new ArrayList<User>();
        List<User> users = (List<User>) session.createCriteria(User.class).list();
        List<UserKey> userKeys = (List<UserKey>) session.createCriteria(UserKey.class).list();
        for (UserKey userKey : userKeys) {
            User user = userKey.getUser();
            user.setUserKey(userKey);
            userList.add(user);
        }
        return userList;
    }

    /**
     * Save User in DB.
     *
     * @param user
     */
    public long addUser(User user) {
        return (Long) getSessionMySQL().save(user);
    }
}
