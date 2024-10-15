package com.eergun.mobilet.service;

import com.eergun.mobilet.dto.request.AddCardWithDto;
import com.eergun.mobilet.dto.request.AddMoneyRequestDto;
import com.eergun.mobilet.entity.card.CardWithSubscription;
import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.exception.MobiletException;
import com.eergun.mobilet.mapper.CardWithSubscriptionMapper;
import com.eergun.mobilet.repository.CardWithSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardWithSubscriptionService {
	private final CardWithSubscriptionRepository repository;
	private final CardUserService cardUserService;
	
	public void save(AddCardWithDto dto) {
		if (cardUserService.existsById(dto.cardUserId()))
			repository.save(CardWithSubscriptionMapper.INSTANCE.fromAddCardWithDto(dto));
		else throw new MobiletException(ErrorType.USER_NOT_FOUND);
	}
	
	public void paySubscription(String cardSerialNumber) {
		CardWithSubscription card = repository.findBySerialNumber(cardSerialNumber);
		if (card == null) throw new MobiletException(ErrorType.CARD_NOT_FOUND);
		else{
			return;
		}
	}
}