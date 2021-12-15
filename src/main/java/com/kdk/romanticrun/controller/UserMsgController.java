package com.kdk.romanticrun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.UserMsgService;
import com.kdk.romanticrun.service.vo.RunMsgVO;
import com.kdk.romanticrun.service.vo.RunRecordVO;
import com.kdk.romanticrun.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserMsgController {

    @Autowired
    private UserMsgService userMsgService;

    @GetMapping(value = "/{uid}/insertUserNameByUid")
    public String insertUserNameByUid(@PathVariable String uid, @RequestParam String username) {
        log.info(uid + "更新昵称" + username);
        userMsgService.insertUseNameByUid(uid, username);
        return "更新成功";
    }

    @GetMapping(value = "/{uid}/insertPhoneByUid")
    public String insertPhoneByUid(@PathVariable String uid, @RequestParam String phone) {
        log.info(uid + "更新电话" + phone);
        userMsgService.insertPhoneByUid(uid, phone);
        return "更新成功";
    }

    @GetMapping(value = "/{uid}/insertAddressByUid")
    public String insertAddressByUid(@PathVariable String uid, @RequestParam String address) {
        log.info(uid + "更新地址" + address);
        userMsgService.insertAddressByUid(uid, address);
        return "更新成功";
    }

    @GetMapping(value = "/{uid}/insertAvatorByUid")
    public String insertAvatorByUid(@PathVariable String uid, @RequestParam String avator) {
        log.info(uid + "更新头像");
        userMsgService.insertAvatorByUid(uid, avator);
        return "更新成功";
    }

    @GetMapping(value = "/{uid}/insertSexByUid")
    public String insertSexByUid(@PathVariable String uid, @RequestParam String sex) {
        log.info(uid + "更新性别" + sex);
        userMsgService.insertSexByUid(uid, sex);
        return "更新成功";
    }

    @GetMapping(value = "/{uid}/insertBirthByUid")
    public String insertBirthByUid(@PathVariable String uid, @RequestParam String birth) {
        log.info(uid + "更新生日" + birth);
        userMsgService.insertBirthByUid(uid, birth);
        return "更新成功";
    }

    @GetMapping(value = "/{uid}/insertSigNatureByUid")
    public String insertSigNatureByUid(@PathVariable String uid, @RequestParam String sigNature) {
        log.info(uid + "更新个性签名" + sigNature);
        userMsgService.insertSigNatureByUid(uid, sigNature);
        return "更新成功";
    }

    @PostMapping(value = "/{uid}/queryTotalUserMsgByUid")
    public UserMsg queryTotalUserMsgByUid(@PathVariable String uid) throws JsonProcessingException {
        UserMsg userMsg = userMsgService.queryTotalUserMsgByUid(uid);
        log.info(uid + "的总信息为: ");
        return userMsg;
    }

    @GetMapping(value = "/{uid}/updateFreeRunTotalMilesByUid")
    public String updateFreeRunTotalMilesByUid(@PathVariable String uid, @RequestParam float FreeRunTotalMiles) {
        userMsgService.updateFreeRunTotalMilesByUid(uid, FreeRunTotalMiles);
        log.info(uid + "增加自由跑里程: " + FreeRunTotalMiles);
        return "更新成功";
    }

    @PostMapping(value = "/{uid}/queryFreeRunTotalMilesByUid")
    public float queryFreeRunTotalMilesByUid(@PathVariable String uid) {
        float ans = userMsgService.queryFreeRunTotalMilesByUid(uid);
        log.info(uid + "的自由跑总里程: " + ans);
        return ans;
    }

    @GetMapping(value = "/{uid}/updateRomanticRunTotalMilesByUid")
    public String updateRomanticRunTotalMilesByUid(@PathVariable String uid, @RequestParam float RomanticRunTotalMiles) {
        userMsgService.updateRomanticRunTotalMilesByUid(uid, RomanticRunTotalMiles);
        log.info(uid + "增加漫跑里程: " + RomanticRunTotalMiles);
        return "更新成功";
    }

    @PostMapping(value = "/{uid}/queryRomanticRunTotalMilesByUid")
    public float queryRomanticRunTotalMilesByUid(@PathVariable String uid) {
        float ans = userMsgService.queryRomanticRunTotalMilesByUid(uid);
        log.info(uid + "的漫跑总里程: " + ans);
        return ans;
    }

    @GetMapping(value = "/{uid}/insertMedalByUid")
    public String insertMedalByUid(@PathVariable String uid, @RequestParam Integer medal) {
        userMsgService.insertMedalByUid(uid, medal);
        return "插入成功";
    }

    /**
     * type = 1 : 总记录； type = 2 : 自由跑；type = 3 : 漫跑
     * @param uid
     * @param type
     * @return
     */
    @PostMapping(value = "/{uid}/queryRunByUid")
    public List<RunRecordVO> queryRunByUid(@PathVariable String uid, @RequestParam int type) {
        List<RunRecordVO> runRecordVOS = userMsgService.queryRunByUid(uid, type);
        log.info(uid + "用户" + "查询跑步记录");
        return runRecordVOS;
    }

    @GetMapping(value = "/{uid}/queryMedalsByUid")
    List<Integer> queryMedalsByUid(@PathVariable String uid) throws JsonProcessingException {
        List<Integer> list = userMsgService.queryMedalsByUid(uid);
        log.info(uid + "的总徽章有: " + JsonUtil.object2Json(list));
        return list;
    }

}


