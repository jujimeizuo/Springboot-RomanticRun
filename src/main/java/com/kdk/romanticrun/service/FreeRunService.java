package com.kdk.romanticrun.service;

import com.kdk.romanticrun.pojo.FreeRun;
import com.kdk.romanticrun.service.vo.RunMsgVO;

import java.util.List;

public interface FreeRunService {

    void insertUserFreeRun(FreeRun freeRun) ;

    List<FreeRun> queryFreeRunByUid(String uid) ;

    List<RunMsgVO> queryFreeRunRank(String flag) ;
}
