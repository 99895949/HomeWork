package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Car;
import com.lx.parkms.repository.CarRepository;
import com.lx.parkms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getOne(String carId) {
        return carRepository.getOne(carId);
    }

    @Override
    public List<Car> getCarByCardId(String cardId) {
        return carRepository.findByCardId(cardId);
    }

    @Override
    public void remove(String cardId) {
        carRepository.deleteById(cardId);
    }
}
