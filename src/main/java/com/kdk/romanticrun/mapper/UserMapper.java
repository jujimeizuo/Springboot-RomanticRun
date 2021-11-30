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
     * 检测数据库是否已存在用户名
     * @param username
     * @return
     */
    User isExistUser(String username) ;

    /**
     * 验证用户是否存在
     * @param user
     * @return
     */
    User verifyUser(User user) ;
}