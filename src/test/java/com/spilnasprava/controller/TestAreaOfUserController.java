package com.spilnasprava.controller;

import com.spilnasprava.business.service.AreaService;
import com.spilnasprava.business.service.UserService;
import com.spilnasprava.entity.mysql.User;
import com.spilnasprava.entity.mysql.UserKey;
import com.spilnasprava.entity.postgresql.Area;
import com.spilnasprava.entity.postgresql.AreaKey;
import com.spilnasprava.object.AreaType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by VJKL on 15.09.2015.
 * Checks the methods of this class
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAreaOfUserController {

    private static Map<User, Area> userMap = new HashMap<User, Area>();
    private static User user = new User();
    private static UserKey userKey = new UserKey();
    private static Area area = new Area();
    private static AreaKey areaKey = new AreaKey();

    @Mock
    private static UserService userService;

    @Mock
    private static AreaService areaService;

    @InjectMocks
    AreaOfUserController controller;

    @BeforeClass
    public static void init() {
        String keyId = "key-test";
        user.setId(1l);
        user.setName("NameTest");
        user.setEmail("EmailTest");
        userKey.setId(1l);
        userKey.setKey(keyId);
        userKey.setUser(user);
        user.setUserKey(userKey);

        area.setId(1l);
        area.setArea(AreaType.AREA1);
        areaKey.setId(1l);
        areaKey.setKey(keyId);
        areaKey.setArea(area);
        area.setAreaKeys(areaKey);

        userMap.put(user, area);
    }

    @Test
    public void testAddUser() {
        try {

            List<User> userList = new ArrayList<User>();
            userList.add(user);
            List<Area> areaList = new ArrayList<Area>();
            areaList.add(area);
            when(userService.getAllUser()).thenReturn(userList);
            when(areaService.getAllArea()).thenReturn(areaList);

            Map<User, Area> userAreaMap = (Map<User, Area>) controller.addUser(user, area).getModel().get("result");
            assertThat(userMap, is(userAreaMap));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUsers() throws IOException {
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        List<Area> areaList = new ArrayList<Area>();
        areaList.add(area);
        when(userService.getAllUser()).thenReturn(userList);
        when(areaService.getAllArea()).thenReturn(areaList);
        Map<User, Area> userAreaMap = (Map<User, Area>) controller.getUsers().getModel().get("result");
        assertThat(userMap, is(userAreaMap));
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        List<Area> areaList = new ArrayList<Area>();
        areaList.add(area);
        when(userService.getAllUser()).thenReturn(userList);
        when(areaService.getAllArea()).thenReturn(areaList);
        Map<User, Area> userAreaMap = controller.getAllUsers();

        assertThat(userMap, is(userAreaMap));
    }
}
