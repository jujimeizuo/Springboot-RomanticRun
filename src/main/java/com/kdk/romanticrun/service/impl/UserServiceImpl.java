package com.kdk.romanticrun.service.impl;

import com.kdk.romanticrun.mapper.UserMapper;
import com.kdk.romanticrun.mapper.UserMsgMapper;
import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.service.MailService;
import com.kdk.romanticrun.service.UserService;
import com.kdk.romanticrun.service.vo.UserVO;
import com.kdk.romanticrun.util.MD5Util;
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

    @Autowired
    private MailService mailService;

    @Override
    public String registerUser(UserVO userVO) {

        // 验证Code
        if(!mailService.verityCode(userVO)) return "验证码错误" ;

        User user1 = new User();
        user1.setEmail(userVO.getEmail());
        user1.setPassword(MD5Util.MD5(userVO.getPassword()));

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        user1.setRegister_time(date); // 获取当前时间
        user1.setUid(UUID.randomUUID().toString());      // 设置uid
        userMapper.registerUser(user1);

        userMsgMapper.insertUid(user1.getUid());

        userMsgMapper.updateRomanticRunTotalMilesByUid(user1.getUid(), 0);
        userMsgMapper.updateFreeRunTotalMilesByUid(user1.getUid(), 0);
        return user1.getUid();

    }

    @Override
    public String login(User user) {
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setPassword(MD5Util.MD5(user.getPassword()));
        if(userMapper.isExistUser(user.getEmail()) == null) return "邮箱不存在";
        else if(userMapper.verifyUser(user1) == null) return "密码错误";
        else return user.getUid();
    }
}
