package com.yhf.springboot.dao;

import com.yhf.springboot.domain.WXUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWXUserDao {
    List<WXUser> getAll();//获取所有（多对多）

    List<String> getOpenId();//获取所以的openid

    List<WXUser> getOpenIdAndWID();//获取指定信息的用户列表

    String getOpId(Integer uid);//根据id获取openid

    Integer getId(String openId);//根据openid获取id
}
