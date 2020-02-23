package com.lx.emp.dao;

import com.lx.emp.pojo.Attendence;
import com.lx.emp.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class AttendenceMapperTest {

    @Autowired
    private AttendenceMapper attendenceMapper;

    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    void insert() {
        Employee employee = employeeMapper.selectByEmpNO("15050025");
        Attendence attendence = new Attendence();
        attendence.setEmpNo(employee.getEmpNo());
        attendence.setEmpName(employee.getEmpName());
        attendence.setAttendBeginTime(new Date());
        int res = attendenceMapper.insert(attendence);
        System.out.println(res);
    }

    @Test
    void findAll() {

        List<Attendence> attendences= attendenceMapper.findAll("","00");
        System.out.println(attendences);
    }
}