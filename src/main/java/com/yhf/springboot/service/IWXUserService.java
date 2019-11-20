package com.yhf.springboot.service;

import com.yhf.springboot.domain.WXUser;

import java.util.List;

public interface IWXUserService {
    List<WXUser> getAll();//获取所有的微信用户

    List<String> getOpenId();
}
