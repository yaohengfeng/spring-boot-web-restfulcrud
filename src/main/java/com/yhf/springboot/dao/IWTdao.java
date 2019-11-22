package com.yhf.springboot.dao;

import com.yhf.springboot.domain.WXUT;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 微信用户和推文之间的中间表dao
 */
@Repository
public interface IWTdao {
    List<WXUT> getAll();//获取信息

    List<WXUT> getAllWT();//获取推送详情的信息

    void insertWT(WXUT wxut);//插入数据

    void updateWT(@Param("wxut")WXUT wxut,@Param("uid_")Integer uId, @Param("tid_")Integer tId);//更新数据

    WXUT selectWTByID(@Param("uid")Integer uId, @Param("tid")Integer tId);//根据推文Id和微信id查询元素是否存在

    List<WXUT> selectWTByTid(Integer tId);//根据推文Id查询出用户表
}
