package com.eergun.mobilet.service;

import com.eergun.mobilet.dto.request.TapRequestDto;
import com.eergun.mobilet.dto.response.BaseResponseDto;
import com.eergun.mobilet.entity.Tapping;
import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.exception.CardNotFoundException;
import com.eergun.mobilet.repository.TappingRepository;
import com.eergun.mobilet.utility.enums.VehicleType;
import com.eergun.mobilet.view.VwTapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TappingService {
	private final TappingRepository tappingRepository;
	private final CardService cardService;
	
	public BaseResponseDto<VwTapping> tapTheCard(TapRequestDto request) {
		String cardSerialNumber = request.getSerialNumber();
		Optional<Card> optCard = cardService.findBySerialNumber(cardSerialNumber);
		if (optCard.isEmpty()) {
			throw new CardNotFoundException();
		}
		else {
			Card card = optCard.get();
			VehicleType vehicleType = request.getVehicleType();
			card.tapTheCard(vehicleType);
			String message = card.getRemainingUsageMessage();
			cardService.save(card);
			tappingRepository.save(Tapping.builder()
					                       .vehicleType(vehicleType)
					                       .cardSerialNumber(cardSerialNumber)
					                       .build());
			return BaseResponseDto.<VwTapping>builder().code(200)
			                      .data(VwTapping.builder().message(message).build())
			                      .message("tapping process successful").success(true).build();
		}
		
		
	}
}