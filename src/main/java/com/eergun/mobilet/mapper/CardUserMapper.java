package com.eergun.mobilet.mapper;

import com.eergun.mobilet.dto.request.CardUserSaveRequestDto;
import com.eergun.mobilet.entity.CardUser;

public interface CardUserMapper {
	public static CardUser mapToCardUser(CardUserSaveRequestDto dto){
		return
				CardUser.builder().name(dto.getName()).lastName(dto.getLastName()).identityNo(dto.getIdentityNo()).adress(dto.getAdress()).email(dto.getEmail()).birthDate(dto.getBirthDate()).password(dto.getPassword()).phone(dto.getPhone()).build();
		
	}
}