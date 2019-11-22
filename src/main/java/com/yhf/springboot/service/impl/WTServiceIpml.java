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

    @Override
    public void insertWT(WXUT wxut) {
       wTdao.insertWT(wxut);
    }

    @Override
    public List<WXUT> selectAllWT() {
        return wTdao.getAllWT();
    }

    @Override
    public WXUT selectWTByID(Integer uId, Integer tId) {
        WXUT wxut = wTdao.selectWTByID(uId, tId);

        return wxut;
    }

    @Override
    public void updateWT( WXUT wxut,Integer uid, Integer tid) {
        wTdao.updateWT(wxut, uid, tid);
    }


    @Override
    public List<WXUT> selectWTByTid(Integer tId) {
        return wTdao.selectWTByTid(tId);
    }
}
