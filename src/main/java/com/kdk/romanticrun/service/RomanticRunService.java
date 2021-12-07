package com.kdk.romanticrun.service;

import com.kdk.romanticrun.pojo.RomanticRun;
import com.kdk.romanticrun.service.vo.RunMsgVO;

import java.util.List;

public interface RomanticRunService {

    void insertUserRomanticRun(String uid, float totalMile, String runTime) ;

    List<RomanticRun> queryRomanticRunByUid(String uid) ;

    List<RunMsgVO> queryRomanticRunRank(String flag) ;

}
