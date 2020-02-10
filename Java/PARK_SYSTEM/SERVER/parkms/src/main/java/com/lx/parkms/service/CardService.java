package com.lx.parkms.service;

import com.lx.parkms.entity.Card;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CardService {

    Card save(Card card);

    List<Card> findByUserName(String userName);

    Page<Card> getAll(Integer page, Integer size,String phone);

    Card getOne(String cardId);

    Card remove(String cardId);

    Card addMoney(String phone,Double money);

    Card findByUserPhone(String phone);
}
