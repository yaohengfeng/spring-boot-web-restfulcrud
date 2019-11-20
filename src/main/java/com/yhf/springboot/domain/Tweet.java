package com.yhf.springboot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 推文类
 */
public class Tweet implements Serializable {

    private Integer id;//id
    private String title;//文章标题
    private String context;//内容
    private Integer number;//浏览次数
    private Date creatTime;//创建时间
    private Date updateTime;//更新时间
    private List<WXUser> wxUsers;//微信用户

    public List<WXUser> getWxUsers() {
        return wxUsers;
    }

    public void setWxUsers(List<WXUser> wxUsers) {
        this.wxUsers = wxUsers;
    }

    public Tweet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Tweets{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", number=" + number +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", wxUsers=" + wxUsers +
                '}';
    }
}
