package com.kdk.romanticrun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kdk.romanticrun.pojo.Dynamic;
import com.kdk.romanticrun.pojo.Result;
import com.kdk.romanticrun.pojo.ResultCode;
import com.kdk.romanticrun.service.DynamicService;
import com.kdk.romanticrun.service.vo.DynamicAndCommentVO;
import com.kdk.romanticrun.service.vo.DynamicVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class DynamicController {

    @Autowired
    private DynamicService dynamicService;

    @PostMapping(value = "insertDynamic")
    public Result insertDynamic(@RequestBody DynamicVO dynamicVO) throws JsonProcessingException {
        dynamicService.insertDynamic(dynamicVO);
        Result r = new Result();
        r.code(ResultCode.SUCCESS).message("发布成功").data(null);
        log.info(r.toString());
        return r;
    }

    @GetMapping(value = "queryDynamic")
    public List<DynamicAndCommentVO> queryDynamic() {
        List<DynamicAndCommentVO> dynamicAndCommentVOS = dynamicService.queryDynamic();
        log.info("查询动态");
        return dynamicAndCommentVOS;
    }

}
