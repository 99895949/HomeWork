package com.lx.emp.service;

import com.lx.emp.pojo.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    void save() {
        Role role = new Role();
        role.setRoleId("001");
        role.setRoleName("测试");
        role.setRoleDescription("测试");
        boolean flag = roleService.save(role);
        Assertions.assertNotNull(flag);
    }


    @Test
    @Rollback(false)
    void update() {
        Role role = roleService.findById("05");
        role.setRoleName("普通员工啊");
        boolean flag = roleService.update(role);
        Assertions.assertNotNull(flag);
    }

    @Test
    void findById() {
        Assertions.assertNotNull(roleService.findById("05"));
    }

    @Test
    void findAll() {
        Assertions.assertNotEquals(0,roleService.findAll().size());
    }
}