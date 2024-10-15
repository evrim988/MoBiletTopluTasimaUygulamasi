package com.eergun.mobilet.controller;

import com.eergun.mobilet.dto.request.AddCardWithDto;
import com.eergun.mobilet.dto.request.AddMoneyRequestDto;
import com.eergun.mobilet.dto.response.BaseResponse;
import com.eergun.mobilet.service.CardWithSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.eergun.mobilet.constants.RestApis.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(CARD_WITH_SUBSCRIPTION)
public class CardWithSubscriptionController {
	private final CardWithSubscriptionService service;
	
	@PostMapping(ADD)
	public ResponseEntity<BaseResponse<Boolean>> createCard(AddCardWithDto dto){
		service.save(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
			                         .code(200).success(true).message("abonman oluşturuldu")
				                         .data(true)
				                             .build());
	}
	
	@PostMapping(PAY)
	public ResponseEntity<BaseResponse<Boolean>> paySubscription(String cardSerialNumber){
		service.paySubscription(cardSerialNumber);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
				                         .success(true).code(200).message("abonman ödemesi başarılı")
				                         .data(true)
				                             .build());
		
	}
}