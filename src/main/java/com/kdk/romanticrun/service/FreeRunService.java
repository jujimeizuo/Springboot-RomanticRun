package com.kdk.romanticrun.service;

import com.kdk.romanticrun.pojo.FreeRun;
import com.kdk.romanticrun.service.vo.RunMsgVO;

import java.text.ParseException;
import java.util.List;

public interface FreeRunService {

    void insertUserFreeRun(String uid, float totalMile, String runTime) ;

    List<FreeRun> queryFreeRunByUid(String uid) ;

    List<RunMsgVO> queryFreeRunRank(String flag) ;
}
