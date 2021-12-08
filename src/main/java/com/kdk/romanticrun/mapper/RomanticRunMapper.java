package com.kdk.romanticrun.mapper;

import com.kdk.romanticrun.pojo.RomanticRun;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RomanticRunMapper {

    /**
     * 插入用户自由跑数据
     * @param romanticRun
     */
    void insertUserRomanticRun(RomanticRun romanticRun) ;

    /**
     * 根据 uid 查询自由跑数据
     * @param uid
     * @return
     */
    List<RomanticRun> queryRomanticRunByUid(String uid) ;

    /**
     * 日榜
     * @return
     */
    List<RomanticRun> queryRomanticRunForDay() ;

    /**
     * 周榜
     * @return
     */
    List<RomanticRun> queryRomanticRunForWeek() ;

    /**
     * 月榜
     * @return
     */
    List<RomanticRun> queryRomanticRunForMonth() ;

    /**
     * 删除 uid用户所有romanticrun
     * @param uid
     */
    void deleteRomanticRun(String uid) ;
}
