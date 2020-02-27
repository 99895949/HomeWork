package com.lx.emp.service;

import com.lx.emp.dao.RoleMapper;
import com.lx.emp.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public boolean save( Role role){
        return roleMapper.insert(role) > 0;
    }

    public boolean remove(String roleId){
        return roleMapper.deleteByPrimaryKey(roleId) > 0;
    }

    public boolean update( Role role){
        return roleMapper.updateByPrimaryKeySelective(role) > 0;
    }

    public Role findById(String roleId){
        return roleMapper.selectByPrimaryKey(roleId);
    }

    public List<Role> findAll(){
        return roleMapper.findAll();
    }
}
