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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/{uid}/update")
    public String update(@PathVariable String uid, @RequestParam String password) {
        String newPassword = userService.updateUser(uid, password);
        log.info(uid + "更换密码：" + password + "->" + newPassword) ;
        return newPassword;
    }

    @PostMapping(value = "/{uid}/delete")
    public String delete(@PathVariable String uid) {
        userService.deleteUser(uid);
        log.info(uid + "用户注销");
        return "注销成功";
    }
}