package com.kdk.romanticrun.controller;

import com.kdk.romanticrun.pojo.Result;
import com.kdk.romanticrun.pojo.ResultCode;
import com.kdk.romanticrun.service.CommentService;
import com.kdk.romanticrun.service.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fengzetao
 * @Date: 2021/12/12 8:38 下午
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("PublishComment")
    public Result PublishComment(@RequestBody CommentVO commentVO) {
        String msg = commentService.PublishComment(commentVO);
        Result r = new Result();
        r.code(ResultCode.SUCCESS).message(msg).data(null);
        return r;
    }
}
