package com.kdk.romanticrun.service;

import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.vo.RunRecordVO;

import java.util.Date;
import java.util.List;

public interface UserMsgService {

    void insertUseNameByUid(String uid, String username) ;

    void insertPhoneByUid(String uid, String phone) ;

    void insertAddressByUid(String uid, String address) ;

    void insertAvatorByUid(String uid, String avator) ;

    void insertSexByUid(String uid, String sex) ;

    void insertBirthByUid(String uid, String birth) ;

    void insertSigNatureByUid(String uid, String sigNature) ;

    UserMsg queryTotalUserMsgByUid(String uid) ;

    void updateFreeRunTotalMilesByUid(String uid, float FreeRunTotalMiles) ;

    float queryFreeRunTotalMilesByUid(String uid) ;

    void updateRomanticRunTotalMilesByUid(String uid, float RomanticRunTotalMiles) ;

    float queryRomanticRunTotalMilesByUid(String uid) ;

    void insertMedalByUid(String uid, Integer medal) ;

    List<RunRecordVO> queryRunByUid(String uid, int type) ;

    List<Integer> queryMedalsByUid(String uid) ;

}
