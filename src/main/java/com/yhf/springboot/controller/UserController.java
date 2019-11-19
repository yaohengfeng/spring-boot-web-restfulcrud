package com.yhf.springboot.controller;

import com.yhf.springboot.domain.User;
import com.yhf.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String name,@RequestParam String pwd){

        Map<String, Object> map = userService.loginUserLock(name);
        if ((boolean)map.get("flag")){
            return "登陆失败，因"+name+"用户登陆次数超过五次，被限制登陆。还剩"+map.get("lockTime")+"分钟";
        }else{
            User user = userService.selectUserByNameAndPassword(name, pwd);
            if (user!=null){
                System.out.println("登陆成功");
                return "success";
            }else {
                System.out.println("登陆失败");
                String result = userService.loginValdate(name);
                return result;
            }
        }
    }



}
