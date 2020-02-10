package com.lx.parkms.controller;

import com.lx.parkms.entity.Charge;
import com.lx.parkms.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/charge")
@RestController
public class ChargeController {

    @Autowired
    private ChargeService chargeService;

    @GetMapping("/charge")
    public List<Charge> findAll(){
        return chargeService.findAll();
    }

    @GetMapping("charge/{id}")
    public Charge getOne(@PathVariable Integer id){
        return chargeService.getOne(id);
    }

    @PutMapping("/charge")
    public Charge update(@RequestBody Charge charge){
        return chargeService.save(charge);
    }


}
