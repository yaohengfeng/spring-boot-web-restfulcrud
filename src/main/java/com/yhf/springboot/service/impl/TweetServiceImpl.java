package com.yhf.springboot.service.impl;

import com.yhf.springboot.dao.ITweetDao;
import com.yhf.springboot.domain.Tweet;
import com.yhf.springboot.service.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetServiceImpl implements ITweetService {

    @Autowired
    private ITweetDao tweetsDao;

    @Override
    public List<Tweet> selectAllTweets() {
        return tweetsDao.getAllTweets();
    }

    @Override
    public Tweet selectTweetsById(Integer tid) {
        return tweetsDao.selectTweetsById(tid);
    }
}
