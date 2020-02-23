package com.lx.emp.service;

import com.lx.emp.dao.AdminMapper;
import com.lx.emp.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin getByName(String name){
        return adminMapper.getByName(name);
    }

    public boolean changePassword(String name,String password){
        return adminMapper.changePassword(name,password) > 1;
    }
}
