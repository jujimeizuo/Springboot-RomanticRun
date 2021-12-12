package com.kdk.romanticrun.service;

import com.kdk.romanticrun.service.vo.UserVO;


public interface MailService {

    String sendMineMail(String email, String flag);

    String randomCode();

    boolean verityCode(UserVO userVO);

}
