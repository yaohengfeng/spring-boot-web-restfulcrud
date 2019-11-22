package com.yhf.springboot.vo;

import java.util.Date;
//没用上
public class WTVO {
    private Integer uId;//用户id
    private Integer tId;//推文id
    private String openid;//openid
    private String nickname;//昵称
    private Integer count;//浏览次数
    private Date browsingTime;//最近浏览时间
    private String title;//文章标题
    private boolean send;//是否推送
    private boolean read;//是否阅读

    public WTVO() {
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getBrowsingTime() {
        return browsingTime;
    }

    public void setBrowsingTime(Date browsingTime) {
        this.browsingTime = browsingTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "WTVO{" +
                "uId=" + uId +
                ", tId=" + tId +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", count=" + count +
                ", browsingTime=" + browsingTime +
                ", title='" + title + '\'' +
                ", send=" + send +
                ", read=" + read +
                '}';
    }
}
