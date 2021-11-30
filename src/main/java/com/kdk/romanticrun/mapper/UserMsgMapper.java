package com.kdk.romanticrun.mapper;

import com.kdk.romanticrun.pojo.UserMsg;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserMsgMapper {

    /**
     * @param uid
     * @param username
     */
    void insertUidAndUserName(String uid, String username) ;

    /**
     * 通过 uid 插入用户电话
     * @param uid
     */
    void insertPhoneByUid(String uid, String phone) ;

    /**
     * 通过 uid 插入用户地址
     * @param uid
     */
    void insertAddressByUid(String uid, String address) ;

    /**
     * 通过 uid 插入用户头像 base64
     * @param uid
     */
    void insertAvatorByUid(String uid, String avator) ;

    /**
     * 通过 uid 插入用户性别
     * @param uid
     */
    void insertSexByUid(String uid, String sex) ;

    /**
     * 通过 uid 插入生日日期
     * @param uid
     */
    void insertBirthByUid(String uid, Date birth) ;

    /**
     * 通过 uid 设置用户个性签名
     * @param uid
     */
    void insertSigNatureByUid(String uid, String sigNature) ;


    /**
     * 通过 uid 查询该用户所有信息
     * @param uid
     * @return
     */
    UserMsg queryTotalUserMsgByUid(String uid) ;

    /**
     * 通过 uid 更新 FreeRunTotalMiles
     * @param uid
     * @param FreeRunTotalMiles
     * @return
     */
    float updateFreeRunTotalMilesByUid(String uid, float FreeRunTotalMiles) ;


    /**
     * 通过 uid 查询总自由跑里程
     * @param uid
     * @return
     */
    float queryFreeRunTotalMilesByUid(String uid) ;


    /**
     * 通过 uid 更新 RomanticRunTotalMiles
     * @param uid
     * @param RomanticRunTotalMiles
     * @return
     */
    float updateRomanticRunTotalMilesByUid(String uid, float RomanticRunTotalMiles) ;

    /**
     * 通过 uid 查询总漫跑里程
     * @param uid
     * @return
     */
    float queryRomanticRunTotalMilesByUid(String uid) ;
}
