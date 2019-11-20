package com.yhf.springboot.controller;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhf.springboot.domain.Msg;
import com.yhf.springboot.domain.Tweet;
import com.yhf.springboot.service.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.List;

/**
 * 推文
 */
@Controller
public class TweetsController {

    @Autowired
    private ITweetService tweetService;

    @GetMapping(name = "/tweets")
    public String getAllTwrrtse(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
        PageHelper.startPage(pn,5);
        List<Tweet> tweets = tweetService.selectAllTweets();
        PageInfo<Tweet> pageInfo=new PageInfo<Tweet>(tweets);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/tweets";
    }

}
