package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Charge;
import com.lx.parkms.repository.ChargeRepository;
import com.lx.parkms.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public Charge getOne(Integer id) {
        return chargeRepository.getOne(id);
    }

    @Override
    public Charge save(Charge charge) {
        return chargeRepository.save(charge);
    }

    @Override
    public List<Charge> findAll() {
        return chargeRepository.findAll();
    }

    @Override
    public List<Charge> findAllByCardType(Integer cardType) {
        return chargeRepository.findAllByCardType(cardType);
    }

    @Override
    public List<Charge> findAllByStationType(Integer stationType) {
        return chargeRepository.findAllByStationType(stationType);
    }
}
