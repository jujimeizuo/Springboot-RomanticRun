package com.kdk.romanticrun.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    /**
     * email         : 邮箱
     * password      : 密码
     * uid           : 用户唯一id
     * register_time : 注册时间
     */

    private String email;
    private String password;
    private String uid;
    private String register_time;

}