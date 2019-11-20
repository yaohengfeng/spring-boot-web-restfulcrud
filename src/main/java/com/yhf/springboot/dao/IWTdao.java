package com.yhf.springboot.dao;

import com.yhf.springboot.domain.WXUT;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 微信用户和推文之间的中间表dao
 */
@Repository
public interface IWTdao {
    List<WXUT> getAll();
}
