package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Permission;
import com.lx.parkms.repository.PermissionRespository;
import com.lx.parkms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRespository permissionRespository;
    @Override
    public List<String> findByPermissionType(Integer type) {
        List<Permission> permissions = permissionRespository.findAllByPermissionType(type);
        List<String> names = new ArrayList<>();
        for (Permission p :
                permissions) {
            names.add(p.getPermissionName());
        }
        return names;
    }

    @Override
    public List<String> findAll() {
        List<Permission> permissions = permissionRespository.findAll();
        List<String> names = new ArrayList<>();
        for (Permission p :
                permissions) {
            names.add(p.getPermissionName());
        }
        return names;
    }
}
