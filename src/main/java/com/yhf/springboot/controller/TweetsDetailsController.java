package com.yhf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhf.springboot.domain.WXUT;
import com.yhf.springboot.service.IWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 推文记录
 */
@Controller
public class TweetsDetailsController {
    @Autowired
    private IWTService wtService;

    @GetMapping("/tweetsinfo/{tid}")
    public String getAllTwrrtseInfo(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@PathVariable("tid")Integer tid, Model model){
        PageHelper.startPage(pn,5);
        /*List<WXUT> wxuts = wtService.selectAllWT();*/
        List<WXUT> wxuts=wtService.selectWTByTid(tid);
        PageInfo<WXUT> pageInfo=new PageInfo<WXUT>(wxuts);
        model.addAttribute("detailsPageInfo",pageInfo);
        return "admin/wxdetails";
    }
}
