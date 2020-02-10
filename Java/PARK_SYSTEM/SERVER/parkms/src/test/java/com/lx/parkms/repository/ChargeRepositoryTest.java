package com.lx.parkms.repository;

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
class ChargeRepositoryTest {

    @Autowired
    private ChargeRepository repository;

    @Test
    void save() {
        Charge charge = new Charge();
        charge.setCardType(CardTypeEnum.VIP.getCode());
        charge.setStationType(StationTypeEnum.SMALL.getCode());
        charge.setPrice(new BigDecimal(2));
        Charge res = repository.save(charge);
        Assertions.assertNotNull(res);
    }

    @Test
    void findAll() {
        List<Charge> charges = repository.findAll();
        for (Charge charge :
                charges) {
            System.out.println(charge);
        }
        Assertions.assertNotEquals(0,charges.size());
    }

    @Test
    void findAllByCardType() {
        List<Charge> charges = repository.findAllByCardType(CardTypeEnum.COMMOM.getCode());
        for (Charge charge :
                charges) {
            System.out.println(charge);
        }
        Assertions.assertNotEquals(0,charges.size());
    }

    @Test
    void findAllByStationType() {
        List<Charge> charges = repository.findAllByStationType(StationTypeEnum.SMALL.getCode());
        for (Charge charge :
                charges) {
            System.out.println(charge);
        }
        Assertions.assertNotEquals(0,charges.size());
    }

    @Test
    void findByCardTypeAndStationType(){
        Charge charge = repository.findByCardTypeAndStationType(0,0);
        System.out.println(charge);
        Assertions.assertNotNull(charge);
    }
}