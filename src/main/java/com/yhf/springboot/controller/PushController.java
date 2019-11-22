package com.yhf.springboot.controller;

import com.yhf.springboot.domain.Tweet;
import com.yhf.springboot.domain.WXUT;
import com.yhf.springboot.domain.WXUser;
import com.yhf.springboot.service.ITweetService;
import com.yhf.springboot.service.IWTService;
import com.yhf.springboot.service.IWXUserService;
import com.yhf.springboot.service.impl.WXUserServiceImpl;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class PushController {

    @Autowired
    private IWXUserService wxUserService;

    @Autowired
    private ITweetService tweetService;

    @Autowired
    private IWTService wtService;

    @GetMapping("/push/{tid}")
    public String push(@PathVariable("tid") Integer tid, HttpServletResponse response) throws IOException {
        List<WXUser> wxUsers = wxUserService.getOpenIdAndWID();

        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wx184763cf4becafd7");
        wxStorage.setSecret("2525fb7713316dd8b8e7820f29d827bd");
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        System.out.println("---------------" + tid);

        Tweet tweet = tweetService.selectTweetsById(tid);


        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("title", tweet.getTitle()),
                new WxMpTemplateData("context", tweet.getContext())
        );

        for (WXUser wxUser : wxUsers) {
            //2,推送消息
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                    //.toUser("oYTNys46a-on1ipmlm_pU9OpypTY")//要推送的用户openid
                    .toUser(wxUser.getOpenid())//要推送的用户openid
                    .data(data)
                    .templateId("gFIRTAc_9vlO6xgwJb0hhuJM1tHoQRaGrjVRLsgz5TQ")//模版id
                    .url("http://yhf.vipgz2.idcfengye.com/wxAuth/login/"+tweet.getId())//点击模版消息要访问的网址
                    .build();
            //3,如果是正式版发送模版消息，这里需要配置你的信息
            //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
            //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
            try {
                WXUT wxut1 = wtService.selectWTByID(wxUser.getId(), tweet.getId());
                if (wxut1 == null) {
                    String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
                    WXUT wxut = new WXUT();
                    wxut.settId(tweet.getId());
                    wxut.setuId(wxUser.getId());
                    wxut.setWtTitle(tweet.getTitle());
                    wxut.setSend(true);
                    wtService.insertWT(wxut);
                    System.out.println("推送成功" + msg);
                }

            } catch (Exception e) {
                System.out.println("推送失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
        return "redirect:/tweets";
    }

    @GetMapping("/pushOne/{uid}/{tid}")
    public String pushOne(@PathVariable("uid") Integer uid,
                          @PathVariable("tid") Integer tid,
                          HttpServletResponse response) throws IOException {
        List<WXUser> wxUsers = wxUserService.getOpenIdAndWID();
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wx184763cf4becafd7");
        wxStorage.setSecret("2525fb7713316dd8b8e7820f29d827bd");
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        Tweet tweet = tweetService.selectTweetsById(tid);

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("title", tweet.getTitle()),
                new WxMpTemplateData("context", tweet.getContext())
        );
        String openId =  wxUserService.getOpId(uid);

        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                //.toUser("oYTNys46a-on1ipmlm_pU9OpypTY")//要推送的用户openid
                .toUser(openId)//要推送的用户openid
                .data(data)
                .templateId("gFIRTAc_9vlO6xgwJb0hhuJM1tHoQRaGrjVRLsgz5TQ")//模版id
                .url("http://yhf.vipgz2.idcfengye.com/wxAuth/login/"+tweet.getId())//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        try {
            String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            System.out.println("推送成功" + msg);

        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/tweets";
    }
}
