package com.kdk.romanticrun.mapper;

import com.kdk.romanticrun.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: fengzetao
 * @Date: 2021/12/12 7:53 下午
 */
@Repository
public interface CommentMapper {

    /**
     * 发表评论
     * @param comment
     */
    void PublishComment(Comment comment);

    /**
     * 获取所有评论
     * @return
     */
    List<Comment> queryAllComment() ;
}
