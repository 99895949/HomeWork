package com.lx.emp.service;

import com.lx.emp.pojo.Permission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class PermisssionServiceTest {

    @Autowired
    private PermissionService permisssionService;


    @Test
    void findById() {
        Assertions.assertNotNull(permisssionService.findById(1));
    }

    @Test
    void findByRoleId() {
        String roleid = "03";
        List<Permission> permissions = permisssionService.findByRoleId(roleid);
        Assertions.assertNotEquals(0,permissions.size());
    }

    @Test
    void findAll() {
        List<Permission> permissions = permisssionService.findAll();
        Assertions.assertNotEquals(0,permissions.size());
    }
}