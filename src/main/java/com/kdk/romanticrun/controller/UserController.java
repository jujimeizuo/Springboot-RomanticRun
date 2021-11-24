package com.kdk.romanticrun.controller;

import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

//    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "register")
    public String registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        String msg = userService.registerUser(user);
        log.info("{username: " + username + ", password: " + password + "}" + msg);
        return msg;
    }

    @PostMapping(value = "login")
    public String login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        String msg = userService.verifyUser(user);
        log.info("{username: " + username + ", password: " + password + "}" + msg);
        return msg;
    }

}
