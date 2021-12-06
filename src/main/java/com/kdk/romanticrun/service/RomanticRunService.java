package com.kdk.romanticrun.service;

import com.kdk.romanticrun.pojo.RomanticRun;
import com.kdk.romanticrun.service.vo.RunMsgVO;

import java.util.List;

public interface RomanticRunService {

    void insertUserRomanticRun(RomanticRun romanticRun) ;

    List<RomanticRun> queryRomanticRunByUid(String uid) ;

    List<RunMsgVO> queryRomanticRunRank(String flag) ;

}
