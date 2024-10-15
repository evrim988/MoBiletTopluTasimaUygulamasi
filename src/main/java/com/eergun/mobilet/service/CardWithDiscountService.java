package com.eergun.mobilet.service;

import com.eergun.mobilet.dto.request.AddCardWithDto;
import com.eergun.mobilet.entity.card.CardWithDiscount;
import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.exception.MobiletException;
import com.eergun.mobilet.mapper.CardWithDiscountMapper;
import com.eergun.mobilet.repository.CardWithDiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardWithDiscountService {
	private final CardWithDiscountRepository cardWithDiscountRepository;
	private final CardUserService cardUserService;
	
	public void save(AddCardWithDto dto) {
		if (cardUserService.existsById(dto.cardUserId()))
			cardWithDiscountRepository.save(CardWithDiscountMapper.INSTANCE
					                                .fromAddCardWithDiscountDto(dto));
		else throw new MobiletException(ErrorType.USER_NOT_FOUND);
		
	}
}