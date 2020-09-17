package com.ranjun1999.personalutils.controller;

import com.ranjun1999.personalutils.model.User;
import com.ranjun1999.personalutils.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ranjun
 * @Date: 2020/7/22 11:34
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    public User getUser(){
        User user = userService.getUser();
        return user;
    }
}
