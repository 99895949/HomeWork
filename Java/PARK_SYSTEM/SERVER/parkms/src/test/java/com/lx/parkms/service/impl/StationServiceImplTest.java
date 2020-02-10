package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Station;
import com.lx.parkms.entity.enums.StationStatusEnum;
import com.lx.parkms.entity.enums.StationTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StationServiceImplTest {

    @Autowired
    private StationServiceImpl stationService;

    @Test
    void save() {
        Station station = null;
        for (int i = 63; i < 70; i++) {
            station = stationService.getOne(i);
            station.setStationStatus(StationStatusEnum.FREE.getCode());
            Station res = stationService.save(station);
            Assertions.assertNotNull(res);
        }

    }

    @Test
    void findSmallAll() {
        Assertions.assertNotEquals(0,stationService.findSmallAll().size());
    }

    @Test
    void findMiddleAll() {
        Assertions.assertNotEquals(0,stationService.findMiddleAll().size());
    }

    @Test
    void findLargeAll() {
        Assertions.assertNotEquals(0,stationService.findLargeAll().size());
    }
}