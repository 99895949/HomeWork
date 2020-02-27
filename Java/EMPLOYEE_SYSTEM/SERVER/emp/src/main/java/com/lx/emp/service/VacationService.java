package com.lx.emp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.emp.dao.VacationMapper;
import com.lx.emp.pojo.Employee;
import com.lx.emp.pojo.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationService {
    
    @Autowired
    private VacationMapper vacationMapper;

    @Autowired
    private EmployeeService employeeService;

    public boolean save(Vacation cacation){
        return vacationMapper.insertSelective(cacation) > 0;
    }

    public boolean remove(Integer id){
        return vacationMapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean update(Vacation cacation){
        return vacationMapper.updateByPrimaryKeySelective(cacation) > 0;
    }

    public Vacation findById(Integer id){
        return vacationMapper.selectByPrimaryKey(id);
    }


    public PageInfo<Vacation> findAll(int page, int size, String name, String no){
        PageHelper.startPage(page,size);
        List<Vacation> vacations = vacationMapper.findAll(name,no);
        PageInfo<Vacation> pageInfo = new PageInfo<>(vacations);
        pageInfo.setList(vacations);
        return pageInfo;
    }

    public PageInfo<Vacation> findMyVacations(int page, int size, String no){
        PageHelper.startPage(page,size);
        List<Vacation> vacations = vacationMapper.findAllByEmpNo(no);
        PageInfo<Vacation> pageInfo = new PageInfo<>(vacations);
        pageInfo.setList(vacations);
        return pageInfo;
    }

    public PageInfo<Vacation> findCommitedVacations(int page, int size,  String name, String no,int status){
        PageHelper.startPage(page,size);
        List<Vacation> vacations = vacationMapper.findAllByStatus(name,no,status);
        PageInfo<Vacation> pageInfo = new PageInfo<>(vacations);
        pageInfo.setList(vacations);
        return pageInfo;
    }


}
