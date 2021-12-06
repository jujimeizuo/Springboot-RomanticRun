package com.kdk.romanticrun.service.impl;

import com.kdk.romanticrun.mapper.RomanticRunMapper;
import com.kdk.romanticrun.mapper.UserMsgMapper;
import com.kdk.romanticrun.pojo.RomanticRun;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.RomanticRunService;
import com.kdk.romanticrun.service.vo.RunMsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RomanticRunServiceImpl implements RomanticRunService {

    @Autowired
    private RomanticRunMapper romanticRunMapper;

    @Autowired
    private UserMsgMapper userMsgMapper;

    public void insertUserRomanticRun(RomanticRun romanticRun) {
        romanticRunMapper.insertUserRomanticRun(romanticRun);
    }

    /**
     * 按照时间排序，传输list
     * @param uid
     * @return
     */
    public List<RomanticRun> queryRomanticRunByUid(String uid) {
        List<RomanticRun> romanticRuns = romanticRunMapper.queryRomanticRunByUid(uid);
        Collections.sort(romanticRuns);
        return romanticRuns;
    }

    // TODO: [username, avator, totalMile]
    /**
     * 时间排序，传输 list of rank
     * @return
     */
    public List<RunMsgVO> queryRomanticRunRank(String flag) {
        List<RomanticRun> romanticRuns;
        if(flag.compareTo("day") == 0)
            romanticRuns = romanticRunMapper.queryRomanticRunForDay();
        else if(flag.compareTo("week") == 0)
            romanticRuns = romanticRunMapper.queryRomanticRunForWeek();
        else
            romanticRuns = romanticRunMapper.queryRomanticRunForMonth();
        HashMap<String, List<RunMsgVO>> stringListHashMap = new HashMap<>();
        for (RomanticRun romanticRun : romanticRuns) {
            List<RunMsgVO> tempList = stringListHashMap.get(romanticRun.getUid());
            RunMsgVO runMsgVO = new RunMsgVO();
            UserMsg userMsg = userMsgMapper.queryTotalUserMsgByUid(romanticRun.getUid());
            runMsgVO.setUsername(userMsg.getUsername() == null ? userMsg.getUid() : userMsg.getUsername());
            runMsgVO.setAvator(userMsg.getAvatar());
            runMsgVO.setTotalMile(romanticRun.getTotalMile());
            tempList.add(runMsgVO);
            stringListHashMap.put(romanticRun.getUid(), tempList);
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
