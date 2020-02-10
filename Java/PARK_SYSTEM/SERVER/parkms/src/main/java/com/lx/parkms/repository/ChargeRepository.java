package com.lx.parkms.repository;

import com.lx.parkms.entity.Charge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Charge,Integer> {

    Charge save(Charge charge);

    List<Charge> findAll();

    List<Charge> findAllByCardType(Integer cardType);

    List<Charge> findAllByStationType(Integer stationType);

    Charge findByCardTypeAndStationType(Integer cardType,Integer stationType);
}
