package com.lx.emp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.emp.dao.AttendenceMapper;
import com.lx.emp.dao.EmployeeMapper;
import com.lx.emp.pojo.Attendence;
import com.lx.emp.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttendenceService {
    
    @Autowired
    private AttendenceMapper attendenceMapper;

    public boolean save(Attendence employee){
        return attendenceMapper.insertSelective(employee) > 0;
    }

    public boolean remove(Integer id){
        return attendenceMapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean update(Attendence employee){
        return attendenceMapper.updateByPrimaryKeySelective(employee) > 0;
    }

    public Attendence findById(Integer id){
        return attendenceMapper.selectByPrimaryKey(id);
    }


    public PageInfo<Attendence> findAll(int page, int size, String name, String no){
        PageHelper.startPage(page,size);
        List<Attendence> employees = attendenceMapper.findAll(name,no);
        PageInfo<Attendence> pageInfo = new PageInfo<>(employees);
        pageInfo.setList(employees);
        return pageInfo;
    }

    public Attendence getByEmpNoAndBeginTime(String no,String begin,String end){
        return attendenceMapper.getByEmpNoAndBeginTime(no,begin,end);
    }
    public Attendence getByEmpNoAndEndTime(String no,String begin,String end){
        return attendenceMapper.getByEmpNoAndEndTime(no,begin,end);
    }
}
