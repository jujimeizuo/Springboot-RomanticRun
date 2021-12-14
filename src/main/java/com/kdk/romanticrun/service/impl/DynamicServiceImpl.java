package com.kdk.romanticrun.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.kdk.romanticrun.mapper.CommentMapper;
import com.kdk.romanticrun.mapper.DynamicMapper;
import com.kdk.romanticrun.mapper.UserMsgMapper;
import com.kdk.romanticrun.pojo.Comment;
import com.kdk.romanticrun.pojo.CommentWithDynamic;
import com.kdk.romanticrun.pojo.Dynamic;
import com.kdk.romanticrun.pojo.UserMsg;
import com.kdk.romanticrun.service.DynamicService;
import com.kdk.romanticrun.service.vo.DynamicAndCommentVO;
import com.kdk.romanticrun.service.vo.DynamicVO;
import com.kdk.romanticrun.util.DateUtil;
import com.kdk.romanticrun.util.JsonUtil;
import com.kdk.romanticrun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    private DynamicMapper dynamicMapper;

    @Autowired
    private UserMsgMapper userMsgMapper;

    @Autowired
    private CommentMapper commentMapper;

    public void insertDynamic(DynamicVO dynamicVO) {
        Dynamic dynamic = new Dynamic();
        UserMsg userMsg = userMsgMapper.queryTotalUserMsgByUid(dynamicVO.getUid());
        dynamic.setFuid(dynamicVO.getUid());
        dynamic.setUsername(userMsg.getUsername());
        dynamic.setIssue(dynamicVO.getIssue());
        dynamic.setCommentNumber(0);
        dynamic.setLikeNumber(0);
        dynamic.setAvator(userMsg.getAvatar());
        dynamic.setPics(StringUtil.listToString(dynamicVO.getPics()));
        dynamic.setDid(UUID.randomUUID().toString());
        dynamic.setIssueTime(DateUtil.timeStamp2Date(DateUtil.getNowTimeStamp(), null));
        dynamicMapper.insertDynamic(dynamic);
    }

    public List<DynamicAndCommentVO> queryDynamic() {
        ArrayList<DynamicAndCommentVO> dcVOS = new ArrayList<>();
        List<Dynamic> dynamics = dynamicMapper.queryDynamic();
        for (Dynamic dynamic : dynamics) {
            DynamicAndCommentVO dcVO = new DynamicAndCommentVO();
            String cid = dynamic.getDid();
            List<Comment> comments = commentMapper.queryAllCommentByCid(cid);
            ArrayList<CommentWithDynamic> cds = new ArrayList<>();
            for (Comment comment : comments) {
                CommentWithDynamic cd = new CommentWithDynamic();
                UserMsg userMsg = userMsgMapper.queryTotalUserMsgByUid(comment.getUid());
                cd.setUsername(userMsg.getUsername());
                cd.setAvator(userMsg.getAvatar());
                cd.setCommentTime(comment.getCommentTime());
                cd.setContent(comment.getContent());
                cds.add(cd);
            }
            Collections.sort(cds);
            dcVO.setDid(dynamic.getDid());
            dcVO.setUid(dynamic.getFuid());
            dcVO.setUsername(dynamic.getUsername());
            dcVO.setCommentNumber(dynamic.getCommentNumber());
            dcVO.setLikeNumber(dynamic.getLikeNumber());
            dcVO.setIssue(dynamic.getIssue());
            dcVO.setIssueTime(dynamic.getIssueTime());
            dcVO.setCommentWithDynamics(cds);
            dcVO.setAvator(dynamic.getAvator());

            dcVO.setPics(StringUtil.stringToList(dynamic.getPics()));

            dcVOS.add(dcVO);
        }
        Collections.sort(dcVOS);
        return dcVOS;
    }

    public void updateLikeNumberByDid(String did) {
        dynamicMapper.updateLikeNumberByDid(did);
    }
}
