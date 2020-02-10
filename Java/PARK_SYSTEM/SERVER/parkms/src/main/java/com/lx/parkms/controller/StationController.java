package com.lx.parkms.controller;

import com.lx.parkms.entity.Station;
import com.lx.parkms.service.StationService;
import com.lx.parkms.vo.FreeStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/station")
@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/station/{id}")
    public Station getOne(@PathVariable Integer id){
        return stationService.getOne(id);
    }

    @DeleteMapping("/station/{id}")
    public Station remove(@PathVariable Integer id){
        return stationService.remove(id);
    }

    @PutMapping("/station")
    public Station update(@RequestBody Station station){
        return stationService.save(station);
    }

    @PostMapping("/station")
    public Station add(@RequestBody Station station){
        return stationService.save(station);
    }

    @GetMapping("/small")
    public List<Station> getSmall(){
        return stationService.findSmallAll();
    }

    @GetMapping("/middle")
    public List<Station> getMiddle(){
        return stationService.findMiddleAll();
    }

    @GetMapping("/large")
    public List<Station> getLarge(){
        return stationService.findLargeAll();
    }

    @GetMapping("/station")
    public Page<Station> getAll(Integer page, Integer size){
        return stationService.getAll(page,size);
    }

    @GetMapping("/freestation")
    public FreeStation getFreeStaions(){
        Integer freeLargeCount = stationService.findLargeAll().size();
        Integer freeMiddleCount = stationService.findMiddleAll().size();
        Integer freeSmallCount = stationService.findSmallAll().size();
        return new FreeStation(freeLargeCount,freeMiddleCount,freeSmallCount);
    }

}
