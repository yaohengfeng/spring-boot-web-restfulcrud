package com.yhf.springboot.controller;

import com.yhf.springboot.domain.User;
import com.yhf.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String loginPages(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes){

        /*Map<String, Object> map = userService.loginUserLock(username);
        if ((boolean)map.get("flag")){
            attributes.addFlashAttribute("messageLock","登陆失败，因"+username+"用户登陆次数超过五次，被限制登陆。还剩"+map.get("lockTime")+"分钟");
            return "redirect:/admin";
        }else{
             User user = userService.selectUserByNameAndPassword(username, password);
            if (user!=null){
                System.out.println("登陆成功");
                session.setAttribute("user",user);
                return "admin/index";
            }else{
                System.out.println("登陆失败");
                attributes.addFlashAttribute("message","用户名或密码错误");
                return "redirect:/admin";
            }
        }*/
        User user = userService.selectUserByNameAndPassword(username, password);
        if (user!=null){
            System.out.println("登陆成功");
            session.setAttribute("user",user);
            return "redirect:/tweets";
        }else{
            System.out.println("登陆失败");
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
