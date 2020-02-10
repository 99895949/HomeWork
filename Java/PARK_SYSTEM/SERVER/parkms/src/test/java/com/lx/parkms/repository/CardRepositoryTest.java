package com.lx.parkms.repository;

import com.lx.parkms.entity.Card;
import com.lx.parkms.entity.enums.CardTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardRepositoryTest {

    @Autowired
    private CardRepository repository;
    @Test
    void save() {
        Card card = new Card();
        card.setCardId("10000");
        card.setUserName("鲁班七号");
        card.setUserPassword("lubanqihao");
        card.setUserPhone("12466875444");
        card.setCardBalance(new BigDecimal(100.2));
        card.setCardType(CardTypeEnum.COMMOM.getCode());
        Card res = repository.save(card);
        Assertions.assertNotNull(res);
    }

    @Test
    void findByUserName() {
        List<Card> cardList = repository.findByUserName("鲁班七号");
        Assertions.assertNotEquals(0,cardList.size());
        Card card = cardList.get(0);
        card.setCardBalance(new BigDecimal(90));
        repository.save(card);
    }

    @Test
    void getOne() {
        Card card = repository.getOne("10000");
        Assertions.assertNotNull(card);
    }
}