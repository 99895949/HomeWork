package com.lx.parkms.service;

import com.lx.parkms.entity.Car;

import java.util.List;

public interface CarService {

    Car save(Car car);

    Car getOne(String carId);

    List<Car> getCarByCardId(String cardId);

    void remove(String cardId);

}
