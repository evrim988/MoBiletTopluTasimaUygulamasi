package com.eergun.mobilet.mapper;

import com.eergun.mobilet.dto.request.CardUserSaveRequestDto;
import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.view.VwCardUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardUserMapper {

	CardUserMapper INSTANCE = Mappers.getMapper(CardUserMapper.class);


	CardUser fromCardUserSaveRequestDto(final CardUserSaveRequestDto cardUserSaveRequestDto);

	VwCardUser fromVwCardUser(CardUser cardUser);
}