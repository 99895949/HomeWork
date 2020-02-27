package com.lx.emp.service;

import com.lx.emp.pojo.Attendence;
import com.lx.emp.util.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
@Transactional
class AttendenceServiceTest {

    @Autowired
    private AttendenceService attendenceService;

    @Test
    void getByEmpNoAndBeginTime() {
        String begin = DateUtils.format(new Date());
        String end = begin + " 23:59:59";
        Attendence attendence = attendenceService.getByEmpNoAndBeginTime("000066",begin,end);
        System.out.println(attendence);
    }

    @Test
    void getByEmpNoAndEndTime() {
        String begin = DateUtils.format(new Date());
        String end = begin + " 23:59:59";
        Attendence attendence = attendenceService.getByEmpNoAndEndTime("00002",begin,end);
        System.out.println(attendence);
    }
}