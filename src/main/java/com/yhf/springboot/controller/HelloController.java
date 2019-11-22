package com.yhf.springboot.controller;

import com.yhf.springboot.domain.WXUT;
import com.yhf.springboot.service.IWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @Autowired
    private IWTService iwtService;

    @GetMapping("/index")
    public String hello(){
        WXUT wxut=new WXUT();


        return "index";
    }
}
