package com.eergun.mobilet.service;

import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.repository.CardUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardUserService {
	private final CardUserRepository cardUserRepository;
	
	public List<CardUser> findAllByNameContaining(String name){
		return cardUserRepository.findAllByNameContainingIgnoreCase(name);
	}

	public void save(CardUser cardUser) {
		cardUserRepository.save(cardUser);
	}
}