package com.lx.emp.service;

import com.github.pagehelper.PageInfo;
import com.lx.emp.pojo.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void findByNO() {
        Employee employee = employeeService.findByNO("00001");
        Assertions.assertNotNull(employee);
    }

    @Test
    void findAll() {
        PageInfo pageInfo = employeeService.findAll(1,5,"","","");
        Assertions.assertNotEquals(0,pageInfo.getSize());
    }

    @Test
    @Rollback(false)
    void changePassword() {
        boolean flag = employeeService.changePassword("00002","111111");
        Assertions.assertNotNull(flag);
    }

    @Test
    @Rollback
    void save() {
        Employee employee = new Employee();
        employee.setEmpNo("12345");
        employee.setDeptId("01");
        employee.setEmpGender("男");
        employee.setEmpEmail("xxx@sdho.com");
        employee.setEmpName("刘禅");
        employee.setEmpStatus(0);
        employee.setEmpIdcard("130283199402365982");
        employee.setEmpPassword("123321");
        employee.setEmpPhone("15236487566");
        employee.setEmpSalerycard("6224980233652115326");
        boolean flag = employeeService.save(employee);
        Assertions.assertNotNull(flag);
    }

    @Test
    @Rollback
    void remove() {
        boolean flag = employeeService.remove(169);
        Assertions.assertNotNull(flag);
    }

    @Test
    @Rollback
    void update() {
        Employee employee = employeeService.findByNO("00000");
        employee.setEmpPassword("000000");
        boolean flag = employeeService.update(employee);
        Assertions.assertNotNull(flag);
    }

    @Test
    void findById() {
        Employee employee = employeeService.findById(155);
        Assertions.assertNotNull(employee.getEmpName());
    }

}