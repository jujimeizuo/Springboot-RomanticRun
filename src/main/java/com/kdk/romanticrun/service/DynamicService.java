package com.kdk.romanticrun.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kdk.romanticrun.pojo.Dynamic;
import com.kdk.romanticrun.service.vo.DynamicAndCommentVO;
import com.kdk.romanticrun.service.vo.DynamicVO;

import java.util.List;

public interface DynamicService {

    void insertDynamic(DynamicVO dynamicVO) throws JsonProcessingException;

    List<DynamicAndCommentVO> queryDynamic() ;
}
