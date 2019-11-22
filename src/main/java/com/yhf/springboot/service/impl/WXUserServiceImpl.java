package com.yhf.springboot.service.impl;

import com.yhf.springboot.dao.IWXUserDao;
import com.yhf.springboot.domain.WXUser;
import com.yhf.springboot.service.IWXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WXUserServiceImpl implements IWXUserService {
    @Autowired
    IWXUserDao iwxUserDao;

    @Override
    public List<WXUser> getAll() {
        return iwxUserDao.getAll();
    }

    @Override
    public List<String> getOpenId() {
        return iwxUserDao.getOpenId();
    }

    @Override
    public List<WXUser> getOpenIdAndWID() {
        return iwxUserDao.getOpenIdAndWID();
    }

    @Override
    public String getOpId(Integer uid) {
        return iwxUserDao.getOpId(uid);
    }

    @Override
    public Integer getId(String openId) {
        return iwxUserDao.getId(openId);
    }

}
