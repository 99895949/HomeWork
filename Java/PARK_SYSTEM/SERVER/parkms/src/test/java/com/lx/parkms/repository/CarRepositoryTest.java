package com.lx.parkms.repository;

import com.lx.parkms.entity.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Test
    void save() {
        Car car = new Car();
        car.setCarId("冀A00003");
        car.setCarType("奥迪A6");
        car.setCardId("10001");
        Car res = repository.save(car);
        Assertions.assertNotNull(res);
    }

    @Test
    void getOne() {
        Optional<Car> car = repository.findById("冀0201A7");
        if(car.isPresent()){
            System.out.println(car.get());
        }else{
            System.out.println("没有查询到");
        }
    }

    @Test
    void findByCardId(){
        List<Car> carList = repository.findByCardId("10001");
        for (Car car :
                carList) {
            System.out.println(car);
        }
        Assertions.assertNotEquals(0,carList.size());
    }
}