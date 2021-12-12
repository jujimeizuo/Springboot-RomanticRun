package com.kdk.romanticrun.mapper;

import com.kdk.romanticrun.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 注册用户
     * @param user
     */
    void registerUser(User user);

    /**
     * 根据 email 查询 uid
     * @param email
     * @return
     */
    User queryUidByEmail(String email) ;

    /**
     * 检测数据库是否已存在用户名
     * @param email
     * @return
     */
    User isExistUser(String email) ;

    /**
     * 验证用户是否存在
     * @param user
     * @return
     */
    User verifyUser(User user) ;

    /**
     * 根据 uid 更新password
     * @param uid
     * @param password
     */
    void updateUser(String uid, String password) ;

    /**
     * 删除 uid 用户
     * @param uid
     */
    void deleteUser(String uid) ;

}