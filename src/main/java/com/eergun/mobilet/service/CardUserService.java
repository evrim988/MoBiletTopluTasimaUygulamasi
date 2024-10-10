package com.eergun.mobilet.service;

import com.eergun.mobilet.dto.request.CardUserSaveRequestDto;
import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.mapper.CardUserMapper;
import com.eergun.mobilet.repository.CardUserRepository;
import com.eergun.mobilet.view.VwCardUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardUserService{
	private final CardUserRepository cardUserRepository;
	
	public List<CardUser> findAllByNameContaining(String name){
		return cardUserRepository.findAllByNameContainingIgnoreCase(name);
	}

	public VwCardUser save(CardUserSaveRequestDto dto) {
		CardUser cardUser = CardUserMapper.mapToCardUser(dto);
		cardUserRepository.save(cardUser);
		return VwCardUser.builder()
				                           .phone(cardUser.getPhone())
				                           .adress(cardUser.getAdress())
				                           .lastName(cardUser.getLastName())
				                           .name(cardUser.getName())
		                                     .build();
	}
}