package com.spilnasprava.controller;

import com.spilnasprava.business.service.AreaService;
import com.spilnasprava.business.service.UserService;
import com.spilnasprava.entity.mysql.User;
import com.spilnasprava.entity.mysql.UserKey;
import com.spilnasprava.entity.postgresql.Area;
import com.spilnasprava.entity.postgresql.AreaKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

/**
 * Performs in methods in Controller.
 */
@Controller
@RequestMapping(value = "/")
public class AreaOfUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AreaService areaService;

    /**
     * Save user data in DB
     *
     * @param user
     * @param area
     * @return all data users
     * @throws IOException
     */
    @RequestMapping(value = "saveuser", produces = "application/json", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute User user, @ModelAttribute Area area) throws IOException {
        String key = UUID.randomUUID().toString();

        UserKey userKey = new UserKey();
        userKey.setKey(key);
        userKey.setUser(user);
        user.setUserKey(userKey);
        userService.addUser(user);

        AreaKey areaKey = new AreaKey();
        areaKey.setKey(key);
        areaKey.setArea(area);
        area.setAreaKeys(areaKey);
        areaService.addArea(area);

        return new ModelAndView("index", "result", getAllUsers());
    }

    /**
     * @return all data users
     * @throws IOException
     */
    @RequestMapping(value = "getusers", produces = "application/json", method = RequestMethod.GET)
    public ModelAndView getUsers() throws IOException {
        return new ModelAndView("index", "result", getAllUsers());
    }

    /**
     * Pulls all data user with MySQL DB and PostgreSQL DB
     * Then compare them and unites in the Map<User, Area>
     * Pass the created Map<User, Area>
     *
     * @return userMap
     */
    public Map<User, Area> getAllUsers() {
        Map<User, Area> userMap = new HashMap<User, Area>();
        List<User> userList = userService.getAllUser();
        List<Area> areaList = areaService.getAllArea();
        for (User user : userList) {
            for (Area area: areaList){
                if (user.getUserKey().getKey().toString().equals(area.getAreaKeys().getKey().toString())){
                    userMap.put(user,area);
                    break;
                }
            }
        }
        return userMap;
    }
}