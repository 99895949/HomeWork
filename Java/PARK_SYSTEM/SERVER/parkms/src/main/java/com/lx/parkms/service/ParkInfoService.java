package com.lx.parkms.service;

import com.lx.parkms.entity.ParkInfo;
import com.lx.parkms.exception.BalanceNotEnoughException;
import com.lx.parkms.exception.CardNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ParkInfoService {

    Page<ParkInfo> findAll(int currentPage, int pageSize,String carId);

    List<ParkInfo> findAllByCardId(String cardId);

    List<ParkInfo> findAllByCarId(String carId);

    /**
     * 车辆驶入
     * @param carId 车牌号
     * @return
     */
    ParkInfo in(String carId);

    /**
     * 车辆驶出
     * @param carId 车牌号
     * @return
     * @throws BalanceNotEnoughException 账户余额不足异常
     */
    ParkInfo out(String carId) throws BalanceNotEnoughException;

    List<ParkInfo> findAllByBeginTimeBetween(String beginString, String endString);

    ParkInfo findByCarIdAndAndPayStatus(String carId,Integer payStatus);

    ParkInfo remove(String id);

    ParkInfo getOne(String id);

    ParkInfo save(ParkInfo parkInfo);

}
