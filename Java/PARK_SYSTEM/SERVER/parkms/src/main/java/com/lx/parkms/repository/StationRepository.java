package com.lx.parkms.repository;

import com.lx.parkms.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station,Integer> {

    List<Station> findByStationStatusAndStationType(Integer status,Integer type);

    List<Station> findByStationLocationIsLike(String pattern);

    Station findByStationLocation(String stationLocation);
}
