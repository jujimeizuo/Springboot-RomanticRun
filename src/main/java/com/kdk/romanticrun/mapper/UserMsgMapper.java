package com.kdk.romanticrun.mapper;

import com.kdk.romanticrun.pojo.UserMsg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMsgMapper {

    // TODO: 注册之后立即设置，头像、个性签名（1、稍后设置， 2、立即设置
    /**
     * 设置 sex， birth， username
     * @param uid
     * @return
     */
    String setUserMsgByUid(String uid) ;

    /**
     * 通过 uid 插入用户头像 base64
     * @param uid
     */
    void insertAvatorByUid(String uid) ;

    /**
     * 通过 uid 设置用户个性签名
     * @param uid
     */
    void insertSigNatureByUid(String uid) ;


    /**
     * 通过 uid 查询该用户所有信息
     * @param uid
     * @return
     */
    UserMsg queryTotalUserMsgByUid(String uid) ;


    /**
     * 通过 uid 查询总自由跑里程
     * @param uid
     * @return
     */
    float queryFreeRunTotalMilesByUid(String uid) ;

    /**
     * 通过 uid 查询总漫跑里程
     * @param uid
     * @return
     */
    float queryRomanticRunTotalMilesByUid(String uid) ;

    //TODO：该资源可存储在前端，可存储在后端
    /**
     * 通过 uid 查询该用户勋章编号列表
     * @param uid
     * @return
     */
    List<Integer> queryMedalByUid(String uid) ;
}
