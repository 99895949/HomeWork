package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceImplTest {

    @Autowired
    private CarServiceImpl service;

    @Test
    void save() {
        Car car = new Car();
        car.setCarId("冀10231");
        car.setCarType("");
        car.setCardId("测试");
        Car res = service.save(car);
        Assertions.assertNotNull(res);
    }

    @Test
    void getOne() {
        Car car = service.getOne("冀A00001");
        System.out.println(car);
        Assertions.assertNotNull(car);
    }

    @Test
    void getCarByCardId() {
        List<Car> carList = service.getCarByCardId("10001");
        for (Car car :
                carList) {
            System.out.println(car);
        }
        Assertions.assertNotEquals(0,carList.size());
    }
}