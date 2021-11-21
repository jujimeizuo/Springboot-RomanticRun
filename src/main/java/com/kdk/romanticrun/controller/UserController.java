package com.kdk.romanticrun.controller;

import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "register")
    public String registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.registerUser(user);
    }

    @PostMapping(value = "login")
    public String login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.verifyUser(user);
    }
}
