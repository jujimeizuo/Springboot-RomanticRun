package com.kdk.romanticrun.controller;

import com.kdk.romanticrun.pojo.FreeRun;
import com.kdk.romanticrun.service.FreeRunService;
import com.kdk.romanticrun.service.vo.RunMsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class FreeRunController {

    @Autowired
    private FreeRunService freeRunService;

    @GetMapping(value = "/{uid}/insertUserFreeRun")
    public void insertUserFreeRun(@PathVariable String uid, @RequestParam float totalMile, @RequestParam String runTime) throws ParseException {
        log.info(uid + " 在 " + runTime + " 自由跑了 " + totalMile);
        freeRunService.insertUserFreeRun(uid, totalMile, runTime);
    }

    @GetMapping(value = "/{uid}/queryFreeRunByUid")
    public List<FreeRun> queryFreeRunByUid(@PathVariable String uid) {
        log.info("获取" + uid + "的所有自由跑信息");
        return freeRunService.queryFreeRunByUid(uid);
    }

    @GetMapping(value = "queryFreeRunRank")
    public List<RunMsgVO> queryFreeRunRank(String flag) {
        log.info("获取" + flag + "榜");
        return freeRunService.queryFreeRunRank(flag);
    }
}
