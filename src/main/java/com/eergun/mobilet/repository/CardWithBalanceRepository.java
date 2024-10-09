package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.card.CardWithBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardWithBalanceRepository extends JpaRepository<CardWithBalance, Long> {

    Optional<CardWithBalance> findOptionalBySerialNumber(String serialNumber);

}
