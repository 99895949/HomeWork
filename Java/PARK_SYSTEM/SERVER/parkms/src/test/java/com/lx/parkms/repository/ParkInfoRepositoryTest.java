package com.lx.parkms.repository;

import com.lx.parkms.entity.Card;
import com.lx.parkms.entity.ParkInfo;
import com.lx.parkms.entity.enums.StationStatusEnum;
import com.lx.parkms.entity.enums.StationTypeEnum;
import com.lx.parkms.util.DateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParkInfoRepositoryTest {

    @Autowired
    private ParkInfoRepository parkInfoRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private CarRepository carRepository;

    @Test
    void findAll() {

        int currentPage = 0;
        int pageSize = 10;
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        Page<ParkInfo> infos = parkInfoRepository.findAll(pageable);
        Assertions.assertEquals(10,infos.getSize());
    }

    @Test
    void findAllByCardId() {
        String cardId = "10001";
        List<ParkInfo> infos = parkInfoRepository.findAllByCardId(cardId);
        for (ParkInfo info :
                infos) {
            System.out.println(info);
        }
        Assertions.assertNotEquals(0,infos.size());
    }

    @Test
    void findAllByCarId() {
        String carId = "冀A00002";
        List<ParkInfo> infos = parkInfoRepository.findAllByCarId(carId);
        for (ParkInfo info :
                infos) {
            System.out.println(info);
        }
        Assertions.assertNotEquals(0,infos.size());
    }

    @Test
    void save() {
        ParkInfo info = new ParkInfo();
        String carId = "冀A00002";
        // 根据车牌号 获取绑定的停车卡id
        String cardId = carRepository.getOne(carId).getCardId();
        // 根据停车卡id 获取用户名
        String username = cardRepository.getOne(cardId).getUserName();
        // 随机找到一个停车位置
        String location = stationRepository.findByStationStatusAndStationType(StationStatusEnum.FREE.getCode(), StationTypeEnum.SMALL.getCode()).get(0).getStationLocation();

        info.setCardId(cardId);
        info.setCarId(carId);
        info.setInfoId( carId + "-" + new Date().getTime());
        info.setStationLocation(location);
        info.setUserName(username);
        info.setBeginTime(new Date());
        ParkInfo res = parkInfoRepository.save(info);
        Assertions.assertNotNull(res);
    }

    @Test
    void findAllByBeginTimeBetween() {
        Date begin = DateUtil.parse("2020-02-01 21:39:30");
        Date end = DateUtil.parse("2020-02-01 21:42:21");
        List<ParkInfo> infos = parkInfoRepository.findAllByBeginTimeBetween(begin,end);
        for (ParkInfo info :
                infos) {
            System.out.println(info);
        }
        Assertions.assertNotEquals(0,infos.size());
    }

    @Test
    void findAllByEndTimeIsNullAndCarId() {
        String carId = "冀A00002";
        List<ParkInfo> infos = parkInfoRepository.findAllByEndTimeIsNullAndCarId(carId);
        for (ParkInfo info :
                infos) {
            System.out.println(info);
        }
        Assertions.assertNotEquals(0,infos.size());
    }

    @Test
    void testfindAllByCarId(){
        String carId = "冀A00002";
        Pageable pageable = PageRequest.of(0,2);
        Page<ParkInfo> infos = parkInfoRepository.findAllByCarId(carId,pageable);
    }
}