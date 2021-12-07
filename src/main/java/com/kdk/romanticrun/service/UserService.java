package com.kdk.romanticrun.service;
import com.kdk.romanticrun.pojo.User;
import com.kdk.romanticrun.service.vo.UserVO;


public interface UserService{

    public String registerUser(UserVO userVO);

    public String login(User user);
}
