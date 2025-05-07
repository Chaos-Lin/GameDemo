package org.example.gamedemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
// 由于 javafx 导入无法解析，推测该导入可能不需要，这里注释掉
 import javafx.concurrent.Service;
import org.example.gamedemo.dto.LoginFormDTO;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.entity.User;

import javax.servlet.http.HttpSession;

public interface IUserService extends IService<User> {

    Result sendCode(String phone,  HttpSession session);


    Result loginCode(LoginFormDTO loginForm);

    Result loginPsw(LoginFormDTO loginForm);

    Result sign();

    Result signCount();


}
