package com.kdk.romanticrun.controller;

import com.kdk.romanticrun.pojo.RomanticRun;
import com.kdk.romanticrun.service.RomanticRunService;
import com.kdk.romanticrun.service.vo.RunMsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class RomanticRunController {

    @Autowired
    private RomanticRunService romanticRunService;

    @GetMapping(value = "/{uid}/insertUserRomanticRun")
    public String insertUserRomanticRun(@PathVariable String uid, @RequestParam float totalMile, @RequestParam String runTime) {
        log.info(uid + " 在 " + runTime + " 漫跑跑了 " + totalMile);
        romanticRunService.insertUserRomanticRun(uid, totalMile, runTime);
        return "插入成功";
    }

    @GetMapping(value = "/{uid}/queryRomanticRunByUid")
    public List<RomanticRun> queryRomanticRunByUid(@PathVariable String uid) {
        log.info("获取" + uid + "的所有漫跑跑信息");
        return romanticRunService.queryRomanticRunByUid(uid);
    }

    @GetMapping(value = "queryRomanticRunRank")
    public List<RunMsgVO> queryRomanticRunRank(String flag) {
        log.info("获取" + flag + "榜");
        return romanticRunService.queryRomanticRunRank(flag);
    }
}
