package com.yhf.springboot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class WXUT implements Serializable {
    private Integer uId;//用户id
    private Integer tId;//推文id
    private String wtTitle;//推文标题
    private Integer count;//浏览次数
    private Date browsingTime;//最近浏览时间
    private boolean send;//是否推送
    private boolean read;//是否阅读
    private WXUser wxUser;//微信用户

    public WXUT() {
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

    public String getWtTitle() {
        return wtTitle;
    }

    public void setWtTitle(String wtTitle) {
        this.wtTitle = wtTitle;
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

    public WXUser getWxUser() {
        return wxUser;
    }

    public void setWxUser(WXUser wxUser) {
        this.wxUser = wxUser;
    }

    @Override
    public String toString() {
        return "WXUT{" +
                "uId=" + uId +
                ", tId=" + tId +
                ", wtTitle='" + wtTitle + '\'' +
                ", count=" + count +
                ", browsingTime=" + browsingTime +
                ", send=" + send +
                ", read=" + read +
                ", wxUser=" + wxUser +
                '}';
    }
}
