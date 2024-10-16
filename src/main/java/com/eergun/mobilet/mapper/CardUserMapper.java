package com.eergun.mobilet.mapper;

import com.eergun.mobilet.dto.request.CardUserSaveRequestDto;
import com.eergun.mobilet.entity.CardUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardUserMapper {

	CardUserMapper INSTANCE = Mappers.getMapper(CardUserMapper.class);

	CardUser fromCardUserSaveRequestDto(final CardUserSaveRequestDto cardUserSaveRequestDto);


	/*public static CardUser mapToCardUser(CardUserSaveRequestDto dto){
		return
				CardUser.builder().stationName(dto.getStationName()).lastName(dto.getLastName()).identityNo(dto.getIdentityNo()).adress(dto.getAdress()).email(dto.getEmail()).birthDate(dto.getBirthDate()).password(dto.getPassword()).phone(dto.getPhone()).build();
		
	}*/
}