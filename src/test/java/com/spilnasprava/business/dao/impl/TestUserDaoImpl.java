package com.spilnasprava.business.dao.impl;

import com.spilnasprava.entity.mysql.User;
import com.spilnasprava.entity.mysql.UserKey;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VJKL on 15.09.2015.
 * Tests methods class UserDaoImpl
 */
@RunWith(MockitoJUnitRunner.class)
public class TestUserDaoImpl {
    private static User user = new User();
    private static UserKey userKey = new UserKey();

    @Mock
    UserDaoImpl userDao;

    @BeforeClass
    public static void init() {
        user.setId(1l);
        user.setName("NameTest");
        user.setEmail("EmailTest");
        userKey.setId(1l);
        userKey.setKey("key-test");
        userKey.setUser(user);
        user.setUserKey(userKey);
    }

    @Test
    public void testGetAllUser() {
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        when(userDao.getAllUser()).thenReturn(userList);
        assertThat(userList, is(userDao.getAllUser()));
    }

    @Test
    public void testAddUser() {
        long userId = 1l;
        when(userDao.addUser(user)).thenReturn(userId);
        assertThat(userId, is(userDao.addUser(user)));
    }
}
