package com.kdk.romanticrun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.UserMsgService;
import com.kdk.romanticrun.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class UserMsgController {

    @Autowired
    private UserMsgService userMsgService;

    @GetMapping(value = "/{uid}/insertPhoneByUid")
    public void insertPhoneByUid(@PathVariable String uid, @RequestParam String phone) {
        log.info(uid + "更新电话" + phone);
        userMsgService.insertPhoneByUid(uid, phone);
    }

    @GetMapping(value = "/{uid}/insertAddressByUid")
    public void insertAddressByUid(@PathVariable String uid, @RequestParam String address) {
        log.info(uid + "更新地址" + address);
        userMsgService.insertAddressByUid(uid, address);
    }

    @GetMapping(value = "/{uid}/insertAvatorByUid")
    public void insertAvatorByUid(@PathVariable String uid, @RequestParam String avator) {
        log.info(uid + "更新头像" + avator);
        userMsgService.insertAvatorByUid(uid, avator);
    }

    @GetMapping(value = "/{uid}/insertSexByUid")
    public void insertSexByUid(@PathVariable String uid, @RequestParam String sex) {
        log.info(uid + "更新性别" + sex);
        userMsgService.insertSexByUid(uid, sex);
    }

    @GetMapping(value = "/{uid}/insertBirthByUid")
    public void insertBirthByUid(@PathVariable String uid, @RequestParam Date birth) {
        log.info(uid + "更新生日" + birth);
        userMsgService.insertBirthByUid(uid, birth);
    }

    @GetMapping(value = "/{uid}/insertSigNatureByUid")
    public void insertSigNatureByUid(@PathVariable String uid, @RequestParam String sigNature) {
        log.info(uid + "更新个性签名" + sigNature);
        userMsgService.insertSigNatureByUid(uid, sigNature);
    }

    @PostMapping(value = "/{uid}/queryTotalUserMsgByUid")
    public UserMsg queryTotalUserMsgByUid(@PathVariable String uid) throws JsonProcessingException {
        UserMsg userMsg = userMsgService.queryTotalUserMsgByUid(uid);
        log.info(uid + "的总信息为: " + JsonUtil.objectToString(userMsg));
        return userMsg;
    }

    @GetMapping(value = "/{uid}/updateFreeRunTotalMilesByUid")
    public void updateFreeRunTotalMilesByUid(@PathVariable String uid, @RequestParam float FreeRunTotalMiles) {
        userMsgService.updateFreeRunTotalMilesByUid(uid, FreeRunTotalMiles);
        log.info(uid + "增加自由跑里程: " + FreeRunTotalMiles);
    }

    @PostMapping(value = "/{uid}/queryFreeRunTotalMilesByUid")
    public float queryFreeRunTotalMilesByUid(@PathVariable String uid) {
        float ans = userMsgService.queryFreeRunTotalMilesByUid(uid);
        log.info(uid + "的自由跑总里程: " + ans);
        return ans;
    }

    @GetMapping(value = "/{uid}/updateRomanticRunTotalMilesByUid")
    public void updateRomanticRunTotalMilesByUid(@PathVariable String uid, @RequestParam float RomanticRunTotalMiles) {
        userMsgService.updateRomanticRunTotalMilesByUid(uid, RomanticRunTotalMiles);
        log.info(uid + "增加漫跑里程: " + RomanticRunTotalMiles);
    }

    @PostMapping(value = "/{uid}/queryRomanticRunTotalMilesByUid")
    public float queryRomanticRunTotalMilesByUid(@PathVariable String uid) {
        float ans = userMsgService.queryRomanticRunTotalMilesByUid(uid);
        log.info(uid + "的漫跑总里程: " + ans);
        return ans;
    }

//    @GetMapping(value = "/{uid}/queryMedalsByUid")
//    List<Integer> queryMedalsByUid(String uid) throws JsonProcessingException {
//        List<Integer> list = userMsgService.queryMedalsByUid(uid);
//        log.info(uid + "的总徽章有: " + JsonUtil.objectToString(list));
//        return list;
//    }

}


