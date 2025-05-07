package org.example.gamedemo.controller;

import org.example.gamedemo.dto.LoginFormDTO;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    IUserService userService;

    @PostMapping("/sendCode")
    public Result sendCode(@RequestParam("phone") String phone, HttpSession session) {
        // 发送短信验证码并保存验证码
        return userService.sendCode(phone, session);
    }

    @PostMapping("/login/psw")
    public Result loginByPsw(@RequestBody LoginFormDTO loginForm) {
        return userService.loginPsw(loginForm);
    }

    @PostMapping("/login/code")
    public Result loginByCode(@RequestBody LoginFormDTO loginForm) {
        return userService.loginCode(loginForm);
    }

    @PostMapping("/logout")
    public Result logout(){
        // todo
        return null;
    }

    @GetMapping("me")
    public Result me(){
        return null;
    }

    @GetMapping("info/{id}")
    public Result infoUser(){
        return null;
    }

    @PostMapping("sign")
    public Result sign(){

        return null;
    }

    @GetMapping("sign/count")
    public Result signCount(){
        return null;
    }
}
