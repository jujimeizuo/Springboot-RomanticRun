package com.kdk.romanticrun.controller;

import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.UserMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class UserMsgController {

    @Autowired
    private UserMsgService userMsgService;

    @GetMapping(value = "/{uid}/insertPhoneByUid")
    public void insertPhoneByUid(@PathVariable String uid, @RequestParam String phone) {
        userMsgService.insertPhoneByUid(uid, phone);
    }

    @GetMapping(value = "/{uid}/insertAddressByUid")
    public void insertAddressByUid(@PathVariable String uid, @RequestParam String address) {
        userMsgService.insertAddressByUid(uid, address);
    }

    @GetMapping(value = "/{uid}/insertAvatorByUid")
    public void insertAvatorByUid(@PathVariable String uid, @RequestParam String avator) {
        userMsgService.insertAvatorByUid(uid, avator);
    }

    @GetMapping(value = "/{uid}/insertSexByUid")
    public void insertSexByUid(@PathVariable String uid, @RequestParam String sex) {
        userMsgService.insertSexByUid(uid, sex);
    }

    @GetMapping(value = "/{uid}/insertBirthByUid")
    public void insertBirthByUid(@PathVariable String uid, @RequestParam Date birth) {
        userMsgService.insertBirthByUid(uid, birth);
    }

    @GetMapping(value = "/{uid}/insertSigNatureByUid")
    public void insertSigNatureByUid(@PathVariable String uid, @RequestParam String sigNature) {
        userMsgService.insertSigNatureByUid(uid, sigNature);
    }

    @GetMapping(value = "/{uid}/queryTotalUserMsgByUid")
    UserMsg queryTotalUserMsgByUid(@PathVariable String uid) {
        return userMsgService.queryTotalUserMsgByUid(uid);
    }

    @GetMapping(value = "/{uid}/queryFreeRunTotalMilesByUid")
    float queryFreeRunTotalMilesByUid(@PathVariable String uid) {
        return userMsgService.queryFreeRunTotalMilesByUid(uid);
    }

    @GetMapping(value = "/{uid}/queryRomanticRunTotalMilesByUid")
    float queryRomanticRunTotalMilesByUid(@PathVariable String uid) {
        return userMsgService.queryRomanticRunTotalMilesByUid(uid);
    }

    @GetMapping(value = "/{uid}/queryMedalsByUid")
    List<Integer> queryMedalsByUid(String uid) {
        return userMsgService.queryMedalsByUid(uid);
    }

}


