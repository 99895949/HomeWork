package com.lx.emp.dao;

import com.lx.emp.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void insert() {
        Employee employee = new Employee();
        for (int i = 0; i < 150; i++) {
            employee.setEmpName("张三");
            employee.setEmpGender("男");
            employee.setEmpNo("1505002" + i);
            employee.setDeptId("05");
            int res = employeeMapper.insert(employee);
            System.out.println(res);
        }


    }

}