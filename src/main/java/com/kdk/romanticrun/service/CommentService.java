package com.kdk.romanticrun.service;

import com.kdk.romanticrun.pojo.Comment;
import com.kdk.romanticrun.service.vo.CommentVO;

import java.util.List;

/**
 * @Author: fengzetao
 * @Date: 2021/12/12 8:25 下午
 */
public interface CommentService {

    String PublishComment(CommentVO commentVO) ;

}
