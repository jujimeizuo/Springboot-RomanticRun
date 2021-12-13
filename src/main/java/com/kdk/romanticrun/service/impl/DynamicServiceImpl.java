package com.kdk.romanticrun.service.impl;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

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
        dynamic.setUsername(userMsg.getUsername());
        dynamic.setIssue(dynamicVO.getIssue());
        dynamic.setCommentNumber(0);
        dynamic.setLikeNumber(0);
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
                cd.setUsername(userMsgMapper.queryTotalUserMsgByUid(comment.getUid()).getUsername());
                cd.setCommentTime(comment.getCommentTime());
                cd.setContent(comment.getContent());
                cds.add(cd);
            }
            Collections.sort(cds);
            dcVO.setUsername(dynamic.getUsername());
            dcVO.setCommentNumber(dynamic.getCommentNumber());
            dcVO.setLikeNumber(dynamic.getLikeNumber());
            dcVO.setIssue(dynamic.getIssue());
            dcVO.setIssueTime(dynamic.getIssueTime());
            dcVO.setCommentWithDynamics(cds);
            dcVOS.add(dcVO);
        }
        Collections.sort(dcVOS);
        return dcVOS;
    }
}
