package com.lx.emp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void findByNO() {
        System.out.println(employeeService.findByNO("1505001"));
    }

    @Test
    void findAll() {
//        PageInfo<Employee> employeePageInfo = employeeService.findAll("","");
//        System.out.println(employeePageInfo);
    }
}