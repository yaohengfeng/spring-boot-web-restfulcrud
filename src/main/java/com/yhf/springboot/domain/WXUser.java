package com.yhf.springboot.domain;

import java.io.Serializable;
import java.util.List;

//微信用户
public class WXUser implements Serializable {
    private Integer Id;//id
    private String openid;//openid
    private String nickname;//昵称
    private String sex;//性别
    private String address;//居住地址
    private List<Tweet> tweets;//推文

    public WXUser() {
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "WXUser{" +
                "Id=" + Id +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", tweets=" + tweets +
                '}';
    }
}
