package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.card.CardWithSubscription;
import com.eergun.mobilet.service.CardWithSubscriptionService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardWithSubscriptionRepository extends JpaRepository<CardWithSubscription, Long> {
	
	CardWithSubscription findBySerialNumber(String cardSerialNumber);
}