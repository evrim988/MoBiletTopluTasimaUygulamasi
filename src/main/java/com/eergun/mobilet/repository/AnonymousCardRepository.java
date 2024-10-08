package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.card.AnonymousCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnonymousCardRepository extends JpaRepository<AnonymousCard, Long> {
	
	Optional<AnonymousCard> findOptionalBySerialNumber(String serialNumber);

	Boolean existsBySerialNumber(String serialNumber);
}