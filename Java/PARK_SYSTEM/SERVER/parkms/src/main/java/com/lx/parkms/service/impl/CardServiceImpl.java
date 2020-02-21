package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Card;
import com.lx.parkms.repository.CardRepository;
import com.lx.parkms.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> findByUserName(String userName) {
        return cardRepository.findByUserName(userName);
    }

    @Override
    public Page<Card> getAll(Integer page, Integer size,String phone) {
        Pageable pageable  = PageRequest.of(page,size);
        if("".equals(phone) || phone == null){
            return cardRepository.findAll(pageable);
        }
        return cardRepository.findAllByUserPhoneLike("%"+phone+"%",pageable);
    }

    @Override
    public Card getOne(String cardId) {
        return cardRepository.getOne(cardId);
    }

    @Override
    public Card remove(String cardId) {
        Card card = cardRepository.getOne(cardId);
        cardRepository.deleteById(card.getCardId());
        return card;
    }

    @Override
    public Card addMoney(String phone, Double money) {
        BigDecimal moneyDecimal = new BigDecimal(money);
        Card card = cardRepository.findByUserPhone(phone);
        card.setCardBalance(card.getCardBalance().add(moneyDecimal));

        return cardRepository.save(card);
    }

    @Override
    public Card findByUserPhone(String phone) {
        return cardRepository.findByUserPhone(phone);
    }
}
