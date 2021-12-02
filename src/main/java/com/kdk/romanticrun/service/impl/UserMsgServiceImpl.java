package com.kdk.romanticrun.service.impl;

import com.kdk.romanticrun.mapper.UserMsgMapper;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserMsgServiceImpl implements UserMsgService {

    @Autowired
    private UserMsgMapper userMsgMapper;
//
//    @Autowired
//    private RedisUtil redisUtil;




    public void insertPhoneByUid(String uid, String phone) {
        userMsgMapper.insertPhoneByUid(uid, phone);
    }

    public void insertAddressByUid(String uid, String address) {
        userMsgMapper.insertAddressByUid(uid, address);
    }

    public void insertAvatorByUid(String uid, String avator) {
        userMsgMapper.insertAvatorByUid(uid, avator);
    }

    public void insertSexByUid(String uid, String sex) {
        userMsgMapper.insertSexByUid(uid, sex);
    }

    public void insertBirthByUid(String uid, Date birth) {
        userMsgMapper.insertBirthByUid(uid, birth);
    }

    public void insertSigNatureByUid(String uid, String sigNature) {
        userMsgMapper.insertSigNatureByUid(uid, sigNature);
    }

    public UserMsg queryTotalUserMsgByUid(String uid) {
        return userMsgMapper.queryTotalUserMsgByUid(uid);
    }

    public void updateFreeRunTotalMilesByUid(String uid, float FreeRunTotalMiles) {
        userMsgMapper.updateFreeRunTotalMilesByUid(uid, FreeRunTotalMiles);
    }

    public float queryFreeRunTotalMilesByUid(String uid) {
        return userMsgMapper.queryFreeRunTotalMilesByUid(uid);
    }

    public void updateRomanticRunTotalMilesByUid(String uid, float RomanticRunTotalMiles) {
        userMsgMapper.updateRomanticRunTotalMilesByUid(uid, RomanticRunTotalMiles);
    }

    public float queryRomanticRunTotalMilesByUid(String uid) {
        return userMsgMapper.queryRomanticRunTotalMilesByUid(uid);
    }

    // TODO: redis缓存
//    public List<Integer> queryMedalsByUid(String uid) {
//        if(redisUtil.lGetListSize(uid) == 0) {
//            return null;
//        }
//        else {
//            List<Object> temp = redisUtil.lGet(uid, 0, -1);
//            List<Integer> medals = null;
//            for (Object o : temp) {
//                medals.add((Integer) o);
//            }
//            return medals;
//        }
//    }
}
