package com.kdk.romanticrun.mapper;

import com.kdk.romanticrun.pojo.FreeRun;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreeRunMapper {

    /**
     * 插入用户自由跑数据
     * @param freeRun
     */
    void insertUserFreeRun(FreeRun freeRun) ;

    /**
     * 根据 uid 查询自由跑数据
     * @param uid
     * @return
     */
    List<FreeRun> queryFreeRunByUid(String uid) ;

    /**
     * 日榜
     * @return
     */
    List<FreeRun> queryFreeRunByUidForDay() ;

    /**
     * 周榜
     * @return
     */
    List<FreeRun> queryFreeRunByUidForWeek() ;

    /**
     * 月榜
     * @return
     */
    List<FreeRun> queryFreeRunByUidForMonth() ;
}
