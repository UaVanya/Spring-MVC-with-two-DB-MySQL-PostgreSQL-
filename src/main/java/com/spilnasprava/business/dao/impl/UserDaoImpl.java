package com.spilnasprava.business.dao.impl;

import com.spilnasprava.business.dao.utils.SeesionBaseInit;
import com.spilnasprava.business.dao.UserDAO;
import com.spilnasprava.entity.mysql.User;
import com.spilnasprava.entity.mysql.UserKey;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends SeesionBaseInit implements UserDAO {

    public List<User> getAllUser() {
        Session session = getSession();
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

    public void addUser(User user) {
        try {
            getSession().save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
