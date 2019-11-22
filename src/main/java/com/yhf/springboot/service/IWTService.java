package com.yhf.springboot.service;

import com.yhf.springboot.domain.WXUT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWTService {
    List<WXUT> selectAll();

    void insertWT(WXUT wxut);//插入中间表

    List<WXUT> selectAllWT();//获取推送的所有信息

    WXUT selectWTByID(Integer uId,Integer tId);//根据推文Id和微信ID来查

    void updateWT(WXUT wxut,Integer uid,Integer tid);//根据推文Id和微信ID来查

    List<WXUT> selectWTByTid(Integer tId);//根据推文Id来查
}
