package com.lx.parkms.repository;

import com.lx.parkms.entity.Admin;
import com.lx.parkms.entity.enums.AdminTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminRepositoryTest {

    @Autowired
    private AdminRepository repository;

    @Test
    void save() {
        Admin admin = new Admin();
        admin.setAdminName("admin");
        admin.setAdminPassword("admin");
        admin.setAdminGender("男");
        admin.setAdminAddress("河南");
        admin.setAdminPhone("15332354555");
        admin.setAdminEmail("admin@163.com");
        admin.setAdminType(AdminTypeEnum.ADMIN.getCode());
        Admin res = repository.save(admin);
        Assertions.assertNotNull(res);
    }
    @Test
    void findByAdminType() {
        Assertions.assertNotEquals(0,repository.findByAdminType(AdminTypeEnum.ADMIN.getCode()).size());
        Assertions.assertNotEquals(0,repository.findByAdminType(AdminTypeEnum.ROOT.getCode()).size());
        Assertions.assertNotEquals(0,repository.findByAdminType(AdminTypeEnum.OPERATOR.getCode()).size());
    }

    @Test
    void findByAdminNameAndAdminPassword(){
        System.out.println(repository.findByAdminNameAndAdminPassword("root","root"));
    }
}