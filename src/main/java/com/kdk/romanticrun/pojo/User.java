package com.kdk.romanticrun.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    /**
     * username      : 账号
     * password      : 密码
     * uid           : 用户唯一id
     * register_time : 注册时间
     * id            : 用户在数据库的id
     */
    private String username;
    private String password;
    private String uid;
    private String register_time;
    private int    id;


}