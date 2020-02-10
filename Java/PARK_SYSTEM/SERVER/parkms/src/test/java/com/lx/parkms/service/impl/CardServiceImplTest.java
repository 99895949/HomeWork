package com.lx.parkms.service.impl;

import cn.binarywang.tools.generator.ChineseMobileNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
import com.lx.parkms.entity.Car;
import com.lx.parkms.entity.Card;
import com.lx.parkms.entity.enums.CardTypeEnum;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CardServiceImplTest {

    @Autowired
    private CardServiceImpl service;

    @Autowired
    private CarServiceImpl carService;

    @Test
    void save() {
        for (int i = 0; i < 50; i++) {
            Card card = new Card();
            String generatedName = ChineseNameGenerator.getInstance().generate();
            String generatedMobileNum = ChineseMobileNumberGenerator.getInstance()
                    .generate();
            String uuid = UUID.randomUUID().toString().substring(0,5);
            card.setCardId(uuid);
            card.setUserName(generatedName);
            card.setUserPassword(uuid);
            card.setUserPhone(generatedMobileNum);
            card.setCardBalance(new BigDecimal(100));
            card.setCardType(CardTypeEnum.COMMOM.getCode());
            service.save(card);

            Car car = new Car();
            car.setCardId(uuid);
            car.setCarType("宝马");
            car.setCarId("冀" + UUID.randomUUID().toString().substring(0,5).toUpperCase());
            carService.save(car);
        }
    }

    @Test
    void findByUserName() {
        List<Card> cardList = service.findByUserName("鲁班七号");
        Assertions.assertNotEquals(0,cardList.size());
        Card card = cardList.get(0);
        card.setCardBalance(new BigDecimal(98));
        service.save(card);
    }
}