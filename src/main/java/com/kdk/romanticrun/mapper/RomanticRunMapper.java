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
     * 根据 uid 查询day自由跑数据
     * @param uid
     * @return
     */
    List<RomanticRun> queryRomanticRunByUidForDay(String uid) ;

    /**
     * 根据 uid 查询week自由跑数据
     * @param uid
     * @return
     */
    List<RomanticRun> queryRomanticRunByUidForWeek(String uid) ;

    /**
     * 根据 uid 查询month自由跑数据
     * @param uid
     * @return
     */
    List<RomanticRun> queryRomanticRunByUidForMonth(String uid) ;
}
