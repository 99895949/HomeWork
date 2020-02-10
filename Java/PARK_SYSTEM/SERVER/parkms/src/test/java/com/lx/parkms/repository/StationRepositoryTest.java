package com.lx.parkms.repository;

import com.lx.parkms.entity.Station;
import com.lx.parkms.entity.enums.StationStatusEnum;
import com.lx.parkms.entity.enums.StationTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StationRepositoryTest {

    @Autowired
    private StationRepository repository;

    @Test
    public void save() {

        List<Station> stationList = repository.findByStationLocationIsLike("%C%");
        for (Station s : stationList
                ) {
            s.setStationType(StationTypeEnum.LARGE.getCode());
            repository.save(s);
        }


    }


    @Test
    void findByStationStatus() {
        Integer status = StationStatusEnum.FREE.getCode();
        Integer type = StationTypeEnum.LARGE.getCode();
        List<Station> stations = repository.findByStationStatusAndStationType(status,type);
        for (Station s:stations
             ) {
            System.out.println(s);
        }
        Assertions.assertNotEquals(0,stations.size());
    }
}