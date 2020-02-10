package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Admin;
import com.lx.parkms.entity.enums.AdminTypeEnum;
import com.lx.parkms.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminServiceImplTest {


    @Autowired
    private AdminServiceImpl service;

    @Test
    void findOperatorAll() {
        Assertions.assertNotEquals(0,service.findOperatorAll().size());
    }

    @Test
    void findAdminAll() {
        Assertions.assertNotEquals(0,service.findAdminAll().size());
    }

    @Test
    void findAll() {
        Assertions.assertNotEquals(0,service.findAll().size());
    }

    @Test
    void save() {
        Admin admin = new Admin();
        admin.setAdminName("刘备");
        admin.setAdminPassword("liubei");
        admin.setAdminGender("男");
        admin.setAdminAddress("四川");
        admin.setAdminPhone("15832654555");
        admin.setAdminEmail("liubei@163.com");
        admin.setAdminType(AdminTypeEnum.OPERATOR.getCode());
        Admin res = service.save(admin);
        Assertions.assertNotNull(res);
    }

    @Test
    void remove() {
        service.remove(6);
    }
}