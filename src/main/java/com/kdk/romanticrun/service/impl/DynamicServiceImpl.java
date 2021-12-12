package com.kdk.romanticrun.service.impl;

import com.kdk.romanticrun.mapper.DynamicMapper;
import com.kdk.romanticrun.mapper.UserMsgMapper;
import com.kdk.romanticrun.pojo.Dynamic;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.DynamicService;
import com.kdk.romanticrun.service.vo.DynamicVO;
import com.kdk.romanticrun.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    private DynamicMapper dynamicMapper;

    @Autowired
    private UserMsgMapper userMsgMapper;

    public void insertDynamic(DynamicVO dynamicVO) {
        Dynamic dynamic = new Dynamic();
        UserMsg userMsg = userMsgMapper.queryTotalUserMsgByUid(dynamicVO.getUid());
        dynamic.setUsername(userMsg.getUsername());
        dynamic.setIssue(dynamicVO.getIssue());
        dynamic.setCommentNumber(0);
        dynamic.setLikeNumber(0);
        dynamic.setDid(UUID.randomUUID().toString());
        dynamic.setIssueTime(DateUtil.timeStamp2Date(DateUtil.getNowTimeStamp(), null));
        dynamicMapper.insertDynamic(dynamic);
    }

    public List<Dynamic> queryDynamic() {
        List<Dynamic> dynamics = dynamicMapper.queryDynamic();
        Collections.sort(dynamics);
        return dynamics;
    }
}
