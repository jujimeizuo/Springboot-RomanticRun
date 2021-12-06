package com.kdk.romanticrun;

import com.kdk.romanticrun.mapper.FreeRunMapper;
import com.kdk.romanticrun.mapper.UserMapper;
import com.kdk.romanticrun.mapper.UserMsgMapper;
import com.kdk.romanticrun.pojo.FreeRun;
import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.UserMsgService;
import com.kdk.romanticrun.service.UserService;
import com.kdk.romanticrun.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootTest
class RomanticRunApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMsgService userMsgService;

    @Autowired
     private UserMsgMapper userMsgMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        User user = new User();
        user.setUsername("r");
        user.setPassword("123456");
        System.out.println(userService.registerUser(user));
    }

    @Test
    void test2() {
        User user = new User();
        user.setUid("121");
        user.setRegister_time("123");
        user.setUsername("root");
        user.setPassword("123456");
        User msg = userMapper.isExistUser(user.getUsername());
    }

    @Test
    void test3() {
        UserMsg userMsg = new UserMsg();
        userMsg.setUsername("123");
        userMsg.setUid("123");
        userMsgMapper.insertUidAndUserName(userMsg.getUid(), userMsg.getUsername());
    }

    @Test
    void test4() {
        UserMsg userMsg = new UserMsg();
        userMsg.setUid("4cca7e11-31a1-443a-8b6c-dae396b87ce3");
        userMsg.setAvatar("11421");
        //userMsgMapper.insertAvatorByUid(userMsg.getUid(), userMsg.getAvatar());
        userMsg.setTotalFreeRunMiles(0);
        userMsgMapper.updateFreeRunTotalMilesByUid(userMsg.getUid(), userMsg.getTotalFreeRunMiles());
        userMsg.setTotalRomanticRunMiles(0);
        userMsgMapper.updateRomanticRunTotalMilesByUid(userMsg.getUid(), userMsg.getTotalRomanticRunMiles());
        userMsg.setTotalMiles(0);

    }

    @Test
    void test5() {
        List<Integer> list = userMsgService.queryMedalsByUid("4cca7e11-31a1-443a-8b6c-dae396b87ce3");
        System.out.println(list);
    }

    @Autowired
    private FreeRunMapper freeRunMapper;

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    @Test
    void test6() throws ParseException {
        FreeRun freeRun = new FreeRun();
        freeRun.setUid("4c1a7e11-31a1-443a-8b6c-da396b87ce3");
        freeRun.setRunTime(sdf1.parse("2021-12-15"));
        freeRun.setTotalMile((float) 123.1);
        freeRunMapper.insertUserFreeRun(freeRun);
    }

    @Test
    void test7() throws ParseException {
        FreeRun freeRun = new FreeRun();
        freeRun.setUid("4cca7e11-31a1-443a-8b6c-dae396b87ce3");
        freeRun.setRunTime(sdf1.parse("2021-12-5"));
        List<FreeRun> freeRuns = freeRunMapper.queryFreeRunByUid("4c1a7e11-31a1-443a-8b6c-da396b87ce3");
        for (FreeRun run : freeRuns) {
            System.out.println(run);
        }
    }

    @Test
    void test8() {
        FreeRun freeRun = new FreeRun();
        List<FreeRun> freeRuns = freeRunMapper.queryFreeRunByUidForMonth();
        for (FreeRun run : freeRuns) {
            System.out.println(run);
        }

    }
}
