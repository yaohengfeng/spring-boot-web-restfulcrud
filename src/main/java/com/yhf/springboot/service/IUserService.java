package com.yhf.springboot.service;

import com.yhf.springboot.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface IUserService {

     List<User> selectAll();

     User selectUserByNameAndPassword(String name,String password);

    /**
     *
     * @param uname 用户名
     * @return 给用户信息提示
     */
     String loginValdate(String uname);

    /**
     * 判断当前用户是否被锁定
     * @param uname
     * @return
     */
    Map<String,Object> loginUserLock(String uname);
}
