package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.card.CardWithBalance;
import com.eergun.mobilet.entity.card.CardWithDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardWithDiscountRepository extends JpaRepository<CardWithDiscount, Long> {
}