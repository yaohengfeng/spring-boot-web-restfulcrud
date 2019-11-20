package com.yhf.springboot.dao;

import com.yhf.springboot.domain.WXUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWXUserDao {
    List<WXUser> getAll();

    List<String> getOpenId();
}
