package com.kdk.romanticrun.service.impl;

import com.kdk.romanticrun.mapper.UserMapper;
import com.kdk.romanticrun.mapper.UserMsgMapper;
import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMsgMapper userMsgMapper;

    @Override
    public String registerUser(User user) {

        // 检测该用户是否已存在
        if(userMapper.isExistUser(user.getUsername()) != null) {
            return "该用户已存在";
        }
        else {
            User user1 = new User();

            user1.setUsername(user.getUsername());           // 设置用户名
            user1.setPassword(user.getPassword());           // 设置密码

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
            user1.setRegister_time(date); // 获取当前时间

            user1.setUid(UUID.randomUUID().toString());      // 设置uid
            userMapper.registerUser(user1);

            userMsgMapper.insertUidAndUserName(user1.getUid(), user1.getUsername());
            userMsgMapper.updateRomanticRunTotalMilesByUid(user1.getUid(), 0);
            userMsgMapper.updateFreeRunTotalMilesByUid(user1.getUid(), 0);
            return user.getUsername() + "用户创建成功";

        }
    }

    @Override
    public String verifyUser(User user) {
        if(userMapper.isExistUser(user.getUsername()) == null) return "用户名错误";
        else if(userMapper.verifyUser(user) == null) return "密码错误";
        else return "success";
    }
}
