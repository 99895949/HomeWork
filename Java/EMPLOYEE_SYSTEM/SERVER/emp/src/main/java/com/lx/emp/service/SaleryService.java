package com.lx.emp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.emp.dao.SaleryMapper;
import com.lx.emp.pojo.Salery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleryService {
    
    @Autowired
    private SaleryMapper saleryMapper;


    public boolean save(Salery salery){
        salery.setCreatetime(new Date());
        salery.setTotal(salery.getWorkSalery().add(salery.getReward()).add(salery.getAllowance()).subtract(salery.getAbsent()).subtract(salery.getVacation()));
        return saleryMapper.insertSelective(salery) > 0;
    }

    public boolean remove(Integer id){
        return saleryMapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean update(Salery salery){
        salery.setTotal(salery.getWorkSalery().add(salery.getReward()).add(salery.getAllowance()).subtract(salery.getAbsent()).subtract(salery.getVacation()));
        return saleryMapper.updateByPrimaryKeySelective(salery) > 0;
    }

    public Salery findById(Integer id){
        return saleryMapper.selectByPrimaryKey(id);
    }


    public PageInfo findAll(int page, int size, String name, String no){
        PageHelper.startPage(page,size);
        List<Salery> salerys = saleryMapper.findAll(name,no);
        PageInfo pageInfo = new PageInfo(salerys);
        pageInfo.setList(salerys);
        return pageInfo;
    }
}
