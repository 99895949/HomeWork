package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Station;
import com.lx.parkms.entity.enums.StationStatusEnum;
import com.lx.parkms.entity.enums.StationTypeEnum;
import com.lx.parkms.repository.StationRepository;
import com.lx.parkms.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;


    @Override
    public Page<Station> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return stationRepository.findAll(pageable);
    }

    @Override
    public Station getOne(Integer id){
        return stationRepository.getOne(id);
    }

    @Override
    public Station remove(Integer id) {
        Station station = stationRepository.getOne(id);
        stationRepository.deleteById(id);
        return station;
    }



    @Override
    public Station save(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public List<Station> findSmallAll() {
        return stationRepository.findByStationStatusAndStationType(StationStatusEnum.FREE.getCode(), StationTypeEnum.SMALL.getCode());
    }

    @Override
    public List<Station> findMiddleAll() {
        return stationRepository.findByStationStatusAndStationType(StationStatusEnum.FREE.getCode(), StationTypeEnum.MIDDLE.getCode());
    }

    @Override
    public List<Station> findLargeAll() {
        return stationRepository.findByStationStatusAndStationType(StationStatusEnum.FREE.getCode(), StationTypeEnum.LARGE.getCode());
    }
}
