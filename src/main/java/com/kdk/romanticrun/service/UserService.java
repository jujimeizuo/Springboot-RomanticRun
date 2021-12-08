package com.kdk.romanticrun.service;
import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.service.vo.UserVO;


public interface UserService{

    String registerUser(UserVO userVO);

    String login(User user);

    void deleteUser(String uid) ;
}
