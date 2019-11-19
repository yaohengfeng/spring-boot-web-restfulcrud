package com.yhf.springboot.domain;

import java.io.Serializable;


public class User implements Serializable {

    private Integer uid;
    private String uName;
    private String uPassword;

    public User() {
    }

    public User(Integer uid, String uName, String uPassword) {
        this.uid = uid;
        this.uName = uName;
        this.uPassword = uPassword;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                '}';
    }


    public static String getKeyName(){
        return "user";
    }

    /**
     * 锁定限制登陆key：user:loginTime:lock:用户名
     * @param uname
     * @return
     */
    public static String getLoginTimeLockKey(String uname){
        return "user:loginTime:lock"+uname;
    }

    /**
     * 登陆失败次数的key user:loginCount:fail:用户名
     */
    public static String getLoginCountFailKey(String uname){
        return "user:loginCount:fail:"+uname;
    }
}
