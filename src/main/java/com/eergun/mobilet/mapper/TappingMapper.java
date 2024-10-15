package com.eergun.mobilet.mapper;

import com.eergun.mobilet.dto.request.TapRequestDto;
import com.eergun.mobilet.entity.Tapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TappingMapper {
	TappingMapper INSTANCE = Mappers.getMapper(TappingMapper.class);
	
	Tapping fromTapRequestDto(TapRequestDto dto);
}