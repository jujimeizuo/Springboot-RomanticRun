package com.kdk.romanticrun.service.impl;

import com.kdk.romanticrun.mapper.FreeRunMapper;
import com.kdk.romanticrun.pojo.FreeRun;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.FreeRunService;
import com.kdk.romanticrun.service.UserMsgService;
import com.kdk.romanticrun.service.vo.RunMsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FreeRunServiceImpl implements FreeRunService {

    @Autowired
    private FreeRunMapper freeRunMapper;

    @Autowired
    private UserMsgService userMsgService;


    public void insertUserFreeRun(String uid, float totalMile, String runTime) {
        FreeRun freeRun = new FreeRun();
        freeRun.setUid(uid);
        freeRun.setTotalMile(totalMile);
        freeRun.setRunTime(runTime);
        userMsgService.updateFreeRunTotalMilesByUid(uid, totalMile);
        freeRun.setRunDate(new Date());
        freeRunMapper.insertUserFreeRun(freeRun);
    }

    /**
     * 按照时间排序，传输list
     * @param uid
     * @return
     */
    public List<FreeRun> queryFreeRunByUid(String uid) {
        List<FreeRun> freeRuns = freeRunMapper.queryFreeRunByUid(uid);
        Collections.sort(freeRuns);
        return freeRuns;
    }

    // TODO: [username, avator, totalMile]
    /**
     * 时间排序，传输 list of rank
     * @return
     */
    public List<RunMsgVO> queryFreeRunRank(String flag) {
        List<FreeRun> freeRuns;
        if(flag.compareTo("day") == 0)
            freeRuns = freeRunMapper.queryFreeRunForDay();
        else if(flag.compareTo("week") == 0)
            freeRuns = freeRunMapper.queryFreeRunForWeek();
        else
            freeRuns = freeRunMapper.queryFreeRunForMonth();
        HashMap<String, List<RunMsgVO>> stringListHashMap = new HashMap<>();
        for (FreeRun freeRun : freeRuns) {
            List<RunMsgVO> tempList = stringListHashMap.get(freeRun.getUid());
            if(tempList == null) tempList = new ArrayList<>();
            RunMsgVO runMsgVO = new RunMsgVO();
            UserMsg userMsg = userMsgService.queryTotalUserMsgByUid(freeRun.getUid());
            // if(userMsg == null) userMsg = new UserMsg();
            runMsgVO.setUsername(userMsg.getUsername() == null ? userMsg.getUid() : userMsg.getUsername());
            runMsgVO.setAvator(userMsg.getAvatar());
            runMsgVO.setTotalMile(freeRun.getTotalMile());
            tempList.add(runMsgVO);
            stringListHashMap.put(freeRun.getUid(), tempList);
        }
        List<RunMsgVO> runMsgVOS = new ArrayList<>();
        if(stringListHashMap.size() > 0) {
            Iterator<Map.Entry<String, List<RunMsgVO>>> it = stringListHashMap.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry<String, List<RunMsgVO>> entry = it.next();
                RunMsgVO rm = new RunMsgVO();
                float totalMile = 0;
                for (RunMsgVO rf : entry.getValue()) {
                    totalMile += rf.getTotalMile();
                }
                rm.setUsername(entry.getValue().get(0).getUsername());
                rm.setAvator(entry.getValue().get(0).getAvator());
                rm.setTotalMile(totalMile);
                runMsgVOS.add(rm);
            }
        }
        Collections.sort(runMsgVOS);
        return runMsgVOS;
    }
}
