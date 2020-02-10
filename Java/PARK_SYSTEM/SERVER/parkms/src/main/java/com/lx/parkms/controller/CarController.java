package com.lx.parkms.controller;

import com.lx.parkms.entity.Car;
import com.lx.parkms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/car")
    public Car add(@RequestBody Car car){
        return carService.save(car);
    }

    @PutMapping("/car")
    public Car update(@RequestBody Car car){
        return carService.save(car);
    }

    @GetMapping("/car/{id}")
    public Car getOne(@PathVariable String id){
        return carService.getOne(id);
    }

    @DeleteMapping("/car/{id}")
    public Car remove(@PathVariable String id){
        Car car = carService.getOne(id);
        carService.remove(id);
        return car;
    }

}
