package com.kdk.romanticrun.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserMsg {

    /**
     * username:   用户昵称
     * uid:        用户uid
     * avatar:     用户头像base64
     * sex:        用户性别
     * birth:      生日
     * sigNature:  个性签名
     * totalMiles: 用户跑的总路程
     * medal:      勋章
     */
    private String username;
    private String uid;
    private String avatar;
    private String sex;
    private Date birth;
    private String sigNature;
    private float totalMiles;
    private int medal;


}
