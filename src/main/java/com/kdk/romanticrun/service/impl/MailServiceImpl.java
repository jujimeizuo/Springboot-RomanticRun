package com.kdk.romanticrun.service.impl;

import com.kdk.romanticrun.mapper.UserMapper;
import com.kdk.romanticrun.service.MailService;
import com.kdk.romanticrun.service.vo.UserVO;
import com.kdk.romanticrun.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private RedisUtil redisUtil;

    // application.properties配置的值
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 给前端输入的邮箱，发送验证码
     * @param email
     * @return
     */

    public String sendMineMail(String email, boolean flag) {
        try {
            if(userMapper.isExistUser(email) != null && flag) return "邮箱已被注册";
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            // 生成随机数
            String code = randomCode();

//            // 将随机数放置到session中
//            session.setAttribute("email", email);
//            session.setAttribute("code", code);

            simpleMailMessage.setSubject("【漫跑】 验证码邮件"); // 主题
            simpleMailMessage.setText("【漫跑】 您的的验证码是：" + code + "，有效期为5分钟，请勿将验证码泄露给他人"); // 内容
            simpleMailMessage.setFrom(from); // 发件人
            simpleMailMessage.setTo(email); // 收件人
            mailSender.send(simpleMailMessage); // 发送

            // 放入redis缓存
            redisUtil.set(email, code, 5 * 60);

            return "邮件发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "注册失败";
        }
    }

    /**
     * 随机生成6位数的验证码
     *
     * @return String code
     */
    @Override
    public String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    /**
     * 检验验证码
     *
     * @param userVO
     * @return
     */

    public boolean verityCode(UserVO userVO) {

        // 获取表单中的提交的code
        String voCode = userVO.getCode();

        // 获取redis缓存中的code
        String code = redisUtil.get(userVO.getEmail()).toString();
        if(code == null || !code.equals(voCode)) {
            return false;
        }

        return true;
    }


}
