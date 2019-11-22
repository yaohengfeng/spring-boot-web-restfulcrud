package com.yhf.springboot.dao;

import com.yhf.springboot.domain.Tweet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITweetDao {
    //获取推文
    List<Tweet> getAllTweets();
    //获取推文加用户信息
    List<Tweet> getAllTweetsAndWXUser();
    //根据id获取推文信息
    Tweet selectTweetsById(Integer tid);
}
