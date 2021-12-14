package com.kdk.romanticrun.service.impl;

import com.kdk.romanticrun.mapper.FreeRunMapper;
import com.kdk.romanticrun.mapper.RomanticRunMapper;
import com.kdk.romanticrun.mapper.UserMsgMapper;
import com.kdk.romanticrun.pojo.FreeRun;
import com.kdk.romanticrun.pojo.RomanticRun;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.UserMsgService;
import com.kdk.romanticrun.service.vo.RunRecordVO;
import com.kdk.romanticrun.util.CastUtil;
import com.kdk.romanticrun.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserMsgServiceImpl implements UserMsgService {

    @Autowired
    private UserMsgMapper userMsgMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private FreeRunMapper freeRunMapper;

    @Autowired
    private RomanticRunMapper romanticRunMapper;

    public void insertUseNameByUid(String uid, String username) {
        userMsgMapper.insertUserNameByUid(uid, username);
    }

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

    public void insertBirthByUid(String uid, String birth) {
        userMsgMapper.insertBirthByUid(uid, birth);
    }

    public void insertSigNatureByUid(String uid, String sigNature) {
        userMsgMapper.insertSigNatureByUid(uid, sigNature);
    }

    public UserMsg queryTotalUserMsgByUid(String uid) {
        return userMsgMapper.queryTotalUserMsgByUid(uid);
    }

    public void updateFreeRunTotalMilesByUid(String uid, float FreeRunTotalMiles) {
        float ans = userMsgMapper.queryFreeRunTotalMilesByUid(uid);
        userMsgMapper.updateFreeRunTotalMilesByUid(uid, ans + FreeRunTotalMiles);
    }

    public float queryFreeRunTotalMilesByUid(String uid) {
        return userMsgMapper.queryFreeRunTotalMilesByUid(uid);
    }

    public void updateRomanticRunTotalMilesByUid(String uid, float RomanticRunTotalMiles) {
        float ans = userMsgMapper.queryRomanticRunTotalMilesByUid(uid);
        userMsgMapper.updateRomanticRunTotalMilesByUid(uid, ans + RomanticRunTotalMiles);
    }

    public float queryRomanticRunTotalMilesByUid(String uid) {
        return userMsgMapper.queryRomanticRunTotalMilesByUid(uid);
    }

    public void insertMedalByUid(String uid, Integer medal) {
        redisUtil.lSet(uid, medal);
    }

    public List<RunRecordVO> queryRunByUid(String uid, int type) {
        List<FreeRun> freeRuns = freeRunMapper.queryFreeRunByUid(uid);
        List<RomanticRun> romanticRuns = romanticRunMapper.queryRomanticRunByUid(uid);
        List<RunRecordVO> runRecordVOS = new ArrayList<>();

        if(type == 1 || type == 2) {
            for (FreeRun freeRun : freeRuns) {
                RunRecordVO runRecordVO = new RunRecordVO();
                runRecordVO.setType(2);
                runRecordVO.setRunTime(freeRun.getRunTime());
                runRecordVO.setTotalMile(freeRun.getTotalMile());
                runRecordVO.setRunDate(freeRun.getRunDate());
                runRecordVOS.add(runRecordVO);
            }
        }

        if(type == 1 || type == 3) {
            for (RomanticRun romanticRun : romanticRuns) {
                RunRecordVO runRecordVO = new RunRecordVO();
                runRecordVO.setType(3);
                runRecordVO.setRunTime(romanticRun.getRunTime());
                runRecordVO.setTotalMile(romanticRun.getTotalMile());
                runRecordVO.setRunDate(romanticRun.getRunDate());
                runRecordVOS.add(runRecordVO);
            }
        }

        Collections.sort(runRecordVOS);
        return runRecordVOS;
    }

    public List<Integer> queryMedalsByUid(String uid) {
        List<Object> temp = redisUtil.lGet(uid, 0, -1);
        assert temp != null;
        List<Integer> list = new ArrayList<Integer>();
        for (Object o : temp) {
            list.add(CastUtil.castInt(o));
        }
        return list;
    }
}
