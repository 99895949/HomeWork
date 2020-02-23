package com.lx.emp.service;

import com.lx.emp.dao.DepartmentMapper;
import com.lx.emp.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public boolean save( Department department){
        return departmentMapper.insert(department) > 0;
    }

    public boolean remove(String deptId){
        return departmentMapper.deleteByPrimaryKey(deptId) > 0;
    }

    public boolean update( Department department){
        return departmentMapper.updateByPrimaryKeySelective(department) > 0;
    }

    public Department findById(String deptId){
        return departmentMapper.selectByPrimaryKey(deptId);
    }

    public List<Department> findAll(String departmentName){
        if(departmentName == null){
            departmentName = "";
        }
        return departmentMapper.findAll(departmentName);
    }
}
