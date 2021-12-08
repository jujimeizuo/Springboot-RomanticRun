package com.kdk.romanticrun.service;
import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.service.vo.UserVO;


public interface UserService{

    String reRegister(String email, String password) ;

    String registerUser(UserVO userVO);

    String login(User user);

    String updateUser(String uid, String password) ;

    void deleteUser(String uid) ;
}
