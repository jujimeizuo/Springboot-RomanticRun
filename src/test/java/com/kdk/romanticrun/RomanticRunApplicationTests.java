package com.kdk.romanticrun;

import com.kdk.romanticrun.mapper.UserMapper;
import com.kdk.romanticrun.mapper.UserMsgMapper;
import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RomanticRunApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
     private UserMsgMapper userMsgMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        User user = new User();
        user.setUsername("r");
        user.setPassword("123456");
        System.out.println(userService.registerUser(user));
    }

    @Test
    void test2() {
        User user = new User();
        user.setUid("121");
        user.setRegister_time("123");
        user.setUsername("root");
        user.setPassword("123456");
        User msg = userMapper.isExistUser(user.getUsername());
    }

    @Test
    void test3() {
        UserMsg userMsg = new UserMsg();
        userMsg.setUsername("123");
        userMsg.setUid("123");
        userMsgMapper.insertUidAndUserName(userMsg.getUid(), userMsg.getUsername());
    }


}
