package com.kdk.romanticrun.service;
import com.kdk.romanticrun.pojo.User;

public interface UserService{

    public String registerUser(User user);

    public String verifyUser(User user);
}
