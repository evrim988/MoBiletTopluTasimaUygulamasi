package com.eergun.mobilet.service;

import com.eergun.mobilet.entity.card.AnonymousCard;
import com.eergun.mobilet.repository.AnonymousCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnonymousCardService{
	private final AnonymousCardRepository anonymousCardRepository;
	
	public Optional<AnonymousCard> findOptionalBySerialNumber(String serialNumber){
		return anonymousCardRepository.findOptionalBySerialNumber(serialNumber);
	}
}