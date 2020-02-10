package com.lx.parkms.service;

import com.lx.parkms.entity.Charge;

import java.util.List;

public interface ChargeService {

    Charge getOne(Integer id);
    Charge save(Charge charge);

    List<Charge> findAll();

    List<Charge> findAllByCardType(Integer cardType);

    List<Charge> findAllByStationType(Integer stationType);
}
