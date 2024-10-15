package com.eergun.mobilet.service;

import com.eergun.mobilet.entity.card.AnonymousCard;
import com.eergun.mobilet.repository.AnonymousCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnonymousCardService{
	private final AnonymousCardRepository anonymousCardRepository;
	private final CardService cardService;


	public List<AnonymousCard> findAll() {
		return anonymousCardRepository.findAll();
	}
	
	public void save() {
		anonymousCardRepository.save(new AnonymousCard());
	}
}