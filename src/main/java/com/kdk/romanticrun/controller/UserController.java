package com.kdk.romanticrun.controller;

import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.service.MailService;
import com.kdk.romanticrun.service.UserMsgService;
import com.kdk.romanticrun.service.UserService;
import com.kdk.romanticrun.service.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @PostMapping(value = "sendEmail")
    public String sendEmail(@RequestParam String email) {
        String msg = mailService.sendMineMail(email);
        log.info("给" + email + "发送验证码");
        log.info(msg);
        return msg;
    }

    @PostMapping(value = "register")
    public String registerUser(@RequestParam String email,@RequestParam String password,@RequestParam String code) {
        UserVO userVO = new UserVO();
        userVO.setEmail(email);
        userVO.setPassword(password);
        userVO.setCode(code);
        String msg = userService.registerUser(userVO);
        log.info(msg);
        return msg;
    }

    @PostMapping(value = "login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        String msg = userService.login(user);
        log.info("msg");
        return msg;
    }

}