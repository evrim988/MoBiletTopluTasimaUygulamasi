package com.eergun.mobilet.mapper;

import com.eergun.mobilet.dto.request.AddCardWithDto;
import com.eergun.mobilet.entity.card.CardWithSubscription;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardWithSubscriptionMapper {
	CardWithSubscriptionMapper INSTANCE = Mappers.getMapper(CardWithSubscriptionMapper.class);
	
	CardWithSubscription fromAddCardWithDto(AddCardWithDto addCardWithDto);
}