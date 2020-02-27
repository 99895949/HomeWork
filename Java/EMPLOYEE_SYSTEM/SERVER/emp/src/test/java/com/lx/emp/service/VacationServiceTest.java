package com.lx.emp.service;

import com.github.pagehelper.PageInfo;
import com.lx.emp.pojo.Employee;
import com.lx.emp.pojo.Vacation;
import com.lx.emp.util.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class VacationServiceTest {

    @Autowired
    private VacationService vacationService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    @Rollback(false)
    void save() {
        Employee employee = employeeService.findByNO("00001");
        Vacation vacation = new Vacation();
        vacation.setBeginTime(DateUtils.parse("2020-02-26","yyyy-MM-dd"));
        vacation.setEndTime(DateUtils.parse("2020-02-29","yyyy-MM-dd"));
        vacation.setEmpName(employee.getEmpName());
        vacation.setEmpNo(employee.getEmpNo());
        vacation.setReason("想回家看看");
        vacation.setStatus(0);
        boolean flag = vacationService.save(vacation);
        Assertions.assertNotNull(flag);
    }

    @Test
    void remove() {
        boolean flag = vacationService.remove(1);
        Assertions.assertNotNull(flag);
    }

    @Test
    @Rollback(false)
    void update() {
        Vacation vacation = vacationService.findById(1);
        Employee employee = employeeService.findByNO("00000");
        vacation.setStatus(2);
        vacation.setApproveNo(employee.getEmpNo());
        vacation.setApproveName(employee.getEmpName());
        vacation.setRemark("公司项目紧急，不批假");
        boolean flag = vacationService.update(vacation);
        Assertions.assertNotNull(flag);

    }

    @Test
    void findById() {
        Vacation vacation = vacationService.findById(1);
        Assertions.assertNotNull(vacation);
    }

    @Test
    void findAll() {
        PageInfo<Vacation> vacationPageInfo = vacationService.findAll(1,5,"","");
        Assertions.assertNotEquals(0,vacationPageInfo.getSize());
    }
}