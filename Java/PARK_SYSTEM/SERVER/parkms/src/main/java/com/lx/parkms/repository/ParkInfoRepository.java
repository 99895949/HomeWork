package com.lx.parkms.repository;

import com.lx.parkms.entity.ParkInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface ParkInfoRepository extends JpaRepository<ParkInfo,String> {

    Page<ParkInfo> findAll(Pageable pageable);

    Page<ParkInfo> findAllByCarId(String carId,Pageable pageable);

    List<ParkInfo> findAllByCardId(String cardId);

    List<ParkInfo> findAllByCarId(String carId);

    ParkInfo save(ParkInfo parkInfo);

    List<ParkInfo> findAllByBeginTimeBetween(Date begin,Date end);

    List<ParkInfo> findAllByEndTimeIsNullAndCarId(String carId);

    ParkInfo findByCarIdAndAndPayStatus(String carId,Integer payStatus);
}
