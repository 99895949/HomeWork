package com.lx.parkms.controller;

import com.lx.parkms.entity.ParkInfo;
import com.lx.parkms.entity.enums.PayStatusEnum;
import com.lx.parkms.entity.enums.PayTypeEnum;
import com.lx.parkms.exception.BalanceNotEnoughException;
import com.lx.parkms.exception.CardNotFoundException;
import com.lx.parkms.service.ParkInfoService;
import com.lx.parkms.util.DateUtil;
import com.lx.parkms.vo.PageVO;
import com.lx.parkms.vo.ParkInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/info")
@CrossOrigin
public class ParkInfoController {

    @Autowired
    private ParkInfoService parkInfoService;

    @PostMapping("/in")
    public ParkInfo in(@RequestParam String carId) {
        return parkInfoService.in(carId);
    }

    @PutMapping("/out")
    public ParkInfo out(@RequestParam String carId){
        try {
            return parkInfoService.out(carId);
        } catch (BalanceNotEnoughException e) {
            return parkInfoService.findByCarIdAndAndPayStatus(carId, PayStatusEnum.WAIT.getCode());
        }
    }

    @GetMapping("/list")
    public PageVO list(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String carId){
        Page<ParkInfo> infos =  parkInfoService.findAll(page,size,carId);
        PageVO res = new PageVO();

        List<ParkInfoVO> parkInfoVOList = new ArrayList<>();
        res.setTotalElements(infos.getTotalElements());
        res.setTotalPages(infos.getTotalPages());
        for (ParkInfo parkinfo :
                infos.getContent()) {
            ParkInfoVO parkInfoVO = new ParkInfoVO();
            BeanUtils.copyProperties(parkinfo,parkInfoVO);
            parkInfoVO.setBeginTimeStr(DateUtil.format(parkInfoVO.getBeginTime(),"yyyy-MM-dd HH:mm:ss"));
            if(parkInfoVO.getEndTime() != null){
                parkInfoVO.setEndTimeStr(DateUtil.format(parkInfoVO.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
            }else{
                parkInfoVO.setEndTimeStr("");
            }
            parkInfoVOList.add(parkInfoVO);
        }
        res.setContent(parkInfoVOList);
        return res;

    }

    @GetMapping("/{id}")
    public ParkInfo getOne(@PathVariable String id){
        return parkInfoService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public ParkInfo remove(@PathVariable  String id){
        return parkInfoService.remove(id);
    }

    @PutMapping("/finish/{id}")
    public ParkInfo finish(@PathVariable String id){
        ParkInfo parkInfo = parkInfoService.getOne(id);
        parkInfo.setPayType(PayTypeEnum.CASH.getCode());
        parkInfo.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        return parkInfoService.save(parkInfo);
    }
}
