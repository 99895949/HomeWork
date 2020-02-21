package com.lx.parkms.repository;

import com.lx.parkms.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,String>{

    Card save(Card card);

    List<Card> findByUserName(String userName);

    Card getOne(String cardId);

    Card findByUserPhone(String phone);

    Page<Card> findAllByUserPhone(String phone, Pageable pageable);

    Page<Card> findAllByUserPhoneLike(String s, Pageable pageable);
}
