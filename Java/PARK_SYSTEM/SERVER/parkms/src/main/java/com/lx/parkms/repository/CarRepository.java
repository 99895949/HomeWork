package com.lx.parkms.repository;

import com.lx.parkms.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,String> {

    Car save(Car car);

    Car getOne(String carId);

    List<Car> findByCardId(String cardId);
}
