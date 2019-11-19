package com.yhf.springboot.controller;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PushController {
    @GetMapping("/push")
    public void push() {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wx184763cf4becafd7");
        wxStorage.setSecret("2525fb7713316dd8b8e7820f29d827bd");
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        List<WxMpTemplateData> data= Arrays.asList(
          new WxMpTemplateData("first","亲，今天怎么样！"),
          new WxMpTemplateData("keyword1","文物会说话"),
          new WxMpTemplateData("keyword2","9.9"),
          new WxMpTemplateData("keyword3","6000万+"),
          new WxMpTemplateData("keyword4","点击阅读")
        );

        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("oYTNys46a-on1ipmlm_pU9OpypTY")//要推送的用户openid
                .data(data)
                .templateId("6zx4WaYyHcRfxk45vIfu8xoBHN0yGVxUZpFRxnDPdfA")//模版id
                .url("http://39.96.16.221:8080/txl")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        try {
            String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            System.out.println("推送成功"+msg);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }

    }
}
