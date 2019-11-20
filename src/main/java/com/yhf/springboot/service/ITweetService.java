package com.yhf.springboot.service;

import com.yhf.springboot.domain.Tweet;

import java.util.List;

public interface ITweetService {
    /**
     * 查询所有推文
     * @return
     */
    List<Tweet> selectAllTweets();
}
