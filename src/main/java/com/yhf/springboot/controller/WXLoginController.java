package com.yhf.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yhf.springboot.domain.Tweet;
import com.yhf.springboot.domain.WXUT;
import com.yhf.springboot.service.ITweetService;
import com.yhf.springboot.service.IWTService;
import com.yhf.springboot.service.IWXUserService;
import com.yhf.springboot.utlis.HttpClientUtil;
import com.yhf.springboot.utlis.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/wxAuth")
public class WXLoginController {

    @Autowired
    private ITweetService tweetService;

    @Autowired
    private IWXUserService iwxUserService;

    @Autowired
    private IWTService iwtService;

    Integer tId;
    @RequestMapping("/login/{tid}")
    public void wxLogin(@PathVariable("tid")Integer tid, HttpServletResponse response) throws IOException {
        //请求获取code的回调地址
        //用线上环境的域名或者用内网穿透，不能用ip
        String callBack = "http://yhf.vipgz2.idcfengye.com/wxAuth/callBack";
        tId=tid;
        //请求地址
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=" + "wx184763cf4becafd7" +
                "&redirect_uri=" + URLEncoder.encode(callBack) +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        //重定向
        response.sendRedirect(url);
    }

    //	回调方法
    @RequestMapping("/callBack")
    public String wxCallBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");

        //获取access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=" + "wx184763cf4becafd7" +
                "&secret=" + "2525fb7713316dd8b8e7820f29d827bd" +
                "&code=" + code +
                "&grant_type=authorization_code";

        String result = HttpClientUtil.doGet(url);

        System.out.println("请求获取access_token:" + result);
        //返回结果的json对象
        JSONObject resultObject = JSON.parseObject(result);

        //请求获取userInfo
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                "?access_token=" + resultObject.getString("access_token") +
                "&openid=" + resultObject.getString("openid") +
                "&lang=zh_CN";

        String resultInfo = HttpClientUtil.doGet(infoUrl);

        //此时已获取到userInfo，再根据业务进行处理
        System.out.println("请求获取userInfo:" + resultInfo);
        Map<String,String> map= UserInfoUtil.toBean(resultInfo);
        String openid=map.get("openid").replace("\"","");
        Integer uid = iwxUserService.getId(openid);
        WXUT wxut = iwtService.selectWTByID(uid, tId);
        Integer count=wxut.getCount();
        if (count==null){
            count=1;
        }else {
            count++;
        }
        wxut.setRead(true);
        wxut.setCount(count);
        Date date=new Date();
        wxut.setBrowsingTime(date);

        iwtService.updateWT(wxut,uid,tId);
        System.out.println("-------------"+map);

        Tweet tweet = tweetService.selectTweetsById(tId);
        Integer number = tweet.getNumber();
        if (number==null){
            number=1;
        }else {
            number++;
        }
        return tweet.getContext();
    }
}

