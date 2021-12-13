package com.kdk.romanticrun.service.impl;

import com.kdk.romanticrun.mapper.CommentMapper;
import com.kdk.romanticrun.mapper.DynamicMapper;
import com.kdk.romanticrun.pojo.Comment;
import com.kdk.romanticrun.service.CommentService;
import com.kdk.romanticrun.service.vo.CommentVO;
import com.kdk.romanticrun.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: fengzetao
 * @Date: 2021/12/12 8:24 下午
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private DynamicMapper dynamicMapper;

    public String PublishComment(CommentVO commentVO) {
        Comment comment = new Comment();
        comment.setCid(commentVO.getDid());
        dynamicMapper.updateCommentNumberByDid(commentVO.getDid());
        comment.setUid(commentVO.getUid());
        comment.setFuid(commentVO.getFuid());
        comment.setContent(commentVO.getContent());
        comment.setCommentTime(DateUtil.timeStamp2Date(DateUtil.getNowTimeStamp(), null));
        commentMapper.PublishComment(comment);
        return "发表评论成功";
    }

}
