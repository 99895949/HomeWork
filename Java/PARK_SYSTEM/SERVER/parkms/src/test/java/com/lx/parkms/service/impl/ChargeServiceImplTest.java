package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Charge;
import com.lx.parkms.entity.enums.CardTypeEnum;
import com.lx.parkms.entity.enums.StationTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChargeServiceImplTest {

    @Autowired
    private ChargeServiceImpl service;

    @Test
    void save() {
        Charge charge = new Charge();
        charge.setCardType(CardTypeEnum.VIP.getCode());
        charge.setStationType(StationTypeEnum.SMALL.getCode());
        charge.setPrice(new BigDecimal(2));
        Charge res = service.save(charge);
        Assertions.assertNotNull(res);
    }

    @Test
    void findAll() {
        List<Charge> charges = service.findAll();
        for (Charge charge :
                charges) {
            System.out.println(charge);
        }
        Assertions.assertNotEquals(0,charges.size());
    }

    @Test
    void findAllByCardType() {
        List<Charge> charges = service.findAllByCardType(CardTypeEnum.COMMOM.getCode());
        for (Charge charge :
                charges) {
            System.out.println(charge);
        }
        Assertions.assertNotEquals(0,charges.size());
    }

    @Test
    void findAllByStationType() {
        List<Charge> charges = service.findAllByStationType(StationTypeEnum.SMALL.getCode());
        for (Charge charge :
                charges) {
            System.out.println(charge);
        }
        Assertions.assertNotEquals(0,charges.size());
    }
}