package com.eergun.mobilet.mapper;

import com.eergun.mobilet.dto.request.AddCardWithDto;
import com.eergun.mobilet.entity.card.CardWithDiscount;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardWithDiscountMapper {
	CardWithDiscountMapper INSTANCE = Mappers.getMapper(CardWithDiscountMapper.class);
	
	CardWithDiscount fromAddCardWithDiscountDto(AddCardWithDto dto);
}