package com.eergun.mobilet.controller;

import com.eergun.mobilet.dto.request.AddCardWithDto;
import com.eergun.mobilet.dto.response.BaseResponse;
import com.eergun.mobilet.service.CardWithDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.eergun.mobilet.constants.RestApis.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(CARD_WITH_DISCOUNT)
public class CardWithDiscountController {
	private final CardWithDiscountService cardWithDiscountService;
	
	@PostMapping(ADD)
	public ResponseEntity<BaseResponse<Boolean>> createCard(AddCardWithDto dto){
		cardWithDiscountService.save(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                     .success(true).message("indirimli kart olusturuldu").code(200)
                                             .data(true)
                                             .build());
	}
}