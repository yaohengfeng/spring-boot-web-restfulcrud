package com.yhf.springboot.service;

import com.yhf.springboot.domain.WXUser;

import java.util.List;

public interface IWXUserService {
    List<WXUser> getAll();//获取所有的微信用户

    List<String> getOpenId();//获取openId

    List<WXUser> getOpenIdAndWID();//获取openID和微信ID

    String getOpId(Integer uid);//获取openid

    Integer getId(String openId);//获取id
}
