package com.lx.emp.service;

import com.lx.emp.dao.PermissionMapper;
import com.lx.emp.dao.RolePermissionMapper;
import com.lx.emp.pojo.Permission;
import com.lx.emp.pojo.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    public boolean save( Permission permission){
        return permissionMapper.insert(permission) > 0;
    }


    public boolean update( Permission permission){
        return permissionMapper.updateByPrimaryKeySelective(permission) > 0;
    }

    public Permission findById(Integer id){
        return permissionMapper.selectByPrimaryKey(id);
    }

    public List<Permission> findByRoleId(String roleId){
        return permissionMapper.findByRoleId(roleId);
    }

    public List<Permission> findAll(){
        return permissionMapper.findAll();
    }

    public boolean addPermissions(String roleId,List<String> permissionIds){

        rolePermissionMapper.deleteByRoleId(roleId);
        for (int i = 0; i < permissionIds.size(); i++) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(Integer.parseInt(permissionIds.get(i)));
            rolePermissionMapper.insertSelective(rolePermission);
        }
        return true;

    }
}
