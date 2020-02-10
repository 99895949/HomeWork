package com.lx.parkms.service.impl;

import com.lx.parkms.exception.BalanceNotEnoughException;
import com.lx.parkms.exception.CardNotFoundException;
import com.lx.parkms.service.ParkInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParkInfoServiceImplTest {

    @Autowired
    private ParkInfoService service;

    @Test
    void findAll() {
    }

    @Test
    void findAllByCardId() {
    }

    @Test
    void findAllByCarId() {
    }

    @Test
    void in() {
        String carId = "冀0210A7";
        service.in(carId);

    }

    @Test
    void out() {
        String carId = "冀0210A7";
        try {
            service.out(carId);
        } catch (BalanceNotEnoughException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAllByBeginTimeBetween() {
    }
}