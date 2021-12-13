package com.kdk.romanticrun.mapper;

import com.kdk.romanticrun.pojo.Dynamic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicMapper {

    /**
     * 插入dynamic数据
     * @param dynamic
     */
    void insertDynamic(Dynamic dynamic) ;

    void updateLikeNumberByDid(String did);

    void updateCommentNumberByDid(String did) ;

    List<Dynamic> queryDynamic() ;

}
