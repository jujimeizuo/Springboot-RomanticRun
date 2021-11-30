package com.kdk.romanticrun.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserMsg {

    /**
     * username:   用户昵称
     * uid:        用户uid
     * phone:      用户电话
     * address:    用户地址
     * avatar:     用户头像base64
     * sex:        用户性别
     * birth:      生日
     * sigNature:  个性签名
     * totalMiles: 用户跑的总路程
     * totalFreeRunMiles: 用户总自由跑里程
     * totalRomanticRunMiles: 用户总漫跑里程
     * rank:       跑步段位
     * medals:     勋章
     */
    private String username;
    private String uid;
    private String phone;
    private String address;
    private String avatar;
    private String sex;
    private Date birth;
    private String sigNature;
    private float totalMiles;
    private float totalFreeRunMiles;
    private float totalRomanticRunMiles;
    private Integer rank;
    private List<Integer> medals;

}
