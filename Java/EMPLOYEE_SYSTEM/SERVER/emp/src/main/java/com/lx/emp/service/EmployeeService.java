package com.lx.emp.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.emp.dao.EmployeeMapper;
import com.lx.emp.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeMapper employeeMapper;

    public boolean changePassword(String no,String password){
        return employeeMapper.changePassword(no,password) > 1;
    }


    public boolean save(Employee employee){
        return employeeMapper.insertSelective(employee) > 0;
    }

    public boolean remove(Integer id){
        return employeeMapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean update(Employee employee){
        return employeeMapper.updateByPrimaryKeySelective(employee) > 0;
    }

    public Employee findById(Integer id){
        return employeeMapper.selectByPrimaryKey(id);
    }

    public Employee findByNO(String empNO){
        return employeeMapper.selectByEmpNO(empNO);
    }

    public PageInfo findAll(int page, int size, String name, String no,String deptId){
        PageHelper.startPage(page,size);
        List<Employee> employees = employeeMapper.findAll(name,no,deptId);
        PageInfo pageInfo = new PageInfo(employees);
        pageInfo.setList(employees);
        return pageInfo;
    }
}
