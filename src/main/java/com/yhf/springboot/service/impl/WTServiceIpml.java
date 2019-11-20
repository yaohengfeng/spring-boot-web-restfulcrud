package com.yhf.springboot.service.impl;

import com.yhf.springboot.dao.IWTdao;
import com.yhf.springboot.domain.WXUT;
import com.yhf.springboot.service.IWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WTServiceIpml implements IWTService {

    @Autowired
    private IWTdao wTdao;

    @Override
    public List<WXUT> selectAll() {
        return wTdao.getAll();
    }
}
