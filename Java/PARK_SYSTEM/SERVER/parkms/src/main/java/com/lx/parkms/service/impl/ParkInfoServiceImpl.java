package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Car;
import com.lx.parkms.entity.Card;
import com.lx.parkms.entity.ParkInfo;
import com.lx.parkms.entity.Station;
import com.lx.parkms.entity.enums.*;
import com.lx.parkms.exception.BalanceNotEnoughException;
import com.lx.parkms.exception.CardNotFoundException;
import com.lx.parkms.repository.*;
import com.lx.parkms.service.ParkInfoService;
import com.lx.parkms.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParkInfoServiceImpl implements ParkInfoService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ParkInfoRepository parkInfoRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public Page<ParkInfo> findAll(int currentPage, int pageSize,String carId) {
        Sort sort = Sort.by(Sort.Direction.DESC,"beginTime");
        Pageable pageable = PageRequest.of(currentPage, pageSize,sort);
        if(carId == null || "".equals(carId)){
            return parkInfoRepository.findAll(pageable);
        }else {
            return parkInfoRepository.findAllByCarIdLike("%"+carId+"%",pageable);
        }
    }

    @Override
    public List<ParkInfo> findAllByCardId(String cardId) {
        return parkInfoRepository.findAllByCardId(cardId);
    }

    @Override
    public List<ParkInfo> findAllByCarId(String carId) {
        return parkInfoRepository.findAllByCarId(carId);
    }

    @Override
    public ParkInfo in(String carId) {
        Car car = null;
        Optional<Car> carOptional = null;
        // 根据车牌号 在数据库查询有没有这辆车
        carOptional = carRepository.findById(carId);
        if (carOptional.isPresent()) {
            // 有这辆车
            car = carOptional.get();
            // 获取绑定的停车卡
            String cardId = car.getCardId();
            // 根据停车卡id 获取用户名
            String username = cardRepository.getOne(cardId).getUserName();
            // 随机找到一个停车位置
            Station station = stationRepository.findByStationStatusAndStationType(StationStatusEnum.FREE.getCode(), StationTypeEnum.SMALL.getCode()).get(0);
            String location = station.getStationLocation();

            // 将停车位置为BUSY
            station.setStationStatus(StationStatusEnum.OCCUPIED.getCode());
            stationRepository.save(station);

            // 插入停车信息
            ParkInfo info = new ParkInfo();
            info.setCardId(cardId);
            info.setCarId(carId);
            info.setInfoId(carId + "-" + new Date().getTime());
            info.setStationLocation(location);
            info.setUserName(username);
            info.setBeginTime(new Date());
            return parkInfoRepository.save(info);
        } else {
            // 没有这辆车，是散户

            // 随机找到一个停车位置
            List<Station> stations = stationRepository.findAll();
            Collections.shuffle(stations);
            Station station = stations.get(0);
            String location = station.getStationLocation();

            // 将停车位置为BUSY
            station.setStationStatus(StationStatusEnum.OCCUPIED.getCode());
            stationRepository.save(station);

            // 插入停车信息
            ParkInfo info = new ParkInfo();
            info.setPayType(PayTypeEnum.CASH.getCode());
            info.setCardId("");
            info.setCarId(carId);
            info.setInfoId(carId + "-" + new Date().getTime());
            info.setStationLocation(location);
            info.setUserName("");
            info.setBeginTime(new Date());
            return parkInfoRepository.save(info);
        }

    }

    @Override
    public ParkInfo out(String carId) throws BalanceNotEnoughException {
        ParkInfo info = parkInfoRepository.findAllByEndTimeIsNullAndCarId(carId).get(0);
        // 设置离开时间
        Date endTime = new Date();
        info.setEndTime(endTime);

        // 将停车位置状态置空闲
        String location = info.getStationLocation();
        Station station = stationRepository.findByStationLocation(location);
        station.setStationStatus(StationStatusEnum.FREE.getCode());
        stationRepository.save(station);

        Optional<Car> carOptional = carRepository.findById(carId);
        if(carOptional.isPresent()){
            // 停车卡扣除费用
            Card card = cardRepository.getOne(carRepository.getOne(carId).getCardId());
            // 计算停车时间(小时)
            double during = DateUtil.getDuring(info.getBeginTime(), endTime);
            BigDecimal price = chargeRepository.findByCardTypeAndStationType(card.getCardType(), station.getStationType()).getPrice();
            BigDecimal total = price.multiply(new BigDecimal(during));
            if (card.getCardBalance().subtract(total).compareTo(new BigDecimal(0)) < 0) {
                parkInfoRepository.save(info);
                throw new BalanceNotEnoughException("账户余额不足，请充值或现金缴费");
            } else {
                card.setCardBalance(card.getCardBalance().subtract(total));
                cardRepository.save(card);
                info.setPayStatus(PayStatusEnum.SUCCESS.getCode());
                return parkInfoRepository.save(info);
            }
        }else{
            parkInfoRepository.save(info);
            throw new BalanceNotEnoughException("账户余额不足，请充值或现金缴费");
        }



    }

    @Override
    public List<ParkInfo> findAllByBeginTimeBetween(String beginString, String endString) {
        Date begin = DateUtil.parse(beginString);
        Date end = DateUtil.parse(endString);
        return parkInfoRepository.findAllByBeginTimeBetween(begin, end);
    }

    @Override
    public ParkInfo findByCarIdAndAndPayStatus(String carId, Integer payStatus) {
        return parkInfoRepository.findByCarIdAndAndPayStatus(carId,payStatus);
    }

    @Override
    public ParkInfo remove(String id) {
        ParkInfo info = parkInfoRepository.getOne(id);
        parkInfoRepository.deleteById(id);
        return info;
    }

    @Override
    public ParkInfo getOne(String id) {
        return parkInfoRepository.getOne(id);
    }

    @Override
    public ParkInfo save(ParkInfo parkInfo) {
        return parkInfoRepository.save(parkInfo);
    }

}
