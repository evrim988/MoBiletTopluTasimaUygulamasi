package com.eergun.mobilet.controller;

import com.eergun.mobilet.dto.request.TapRequestDto;
import com.eergun.mobilet.dto.response.BaseResponseDto;
import com.eergun.mobilet.dto.response.TransactionDateDto;
import com.eergun.mobilet.entity.Tapping;
import com.eergun.mobilet.exceptions.BakiyeYetersizException;
import com.eergun.mobilet.exceptions.CardNotFoundException;
import com.eergun.mobilet.service.TappingService;
import com.eergun.mobilet.view.VwTapping;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.eergun.mobilet.constants.RestApis.*;
@RestController
@RequestMapping(TAPPING)
@RequiredArgsConstructor
public class TappingController {
	private final TappingService tappingService;
	
	@PostMapping(ODEME)
	@ResponseBody
	public ResponseEntity<BaseResponseDto<VwTapping>> tapTheCard(@Valid @RequestBody TapRequestDto request) {
		BaseResponseDto<VwTapping> responseDto;
		String serverMessage = null;
		Integer code = null;
		try {
			responseDto = tappingService.tapTheCard(request);
			return ResponseEntity.ok(responseDto);
		}
		catch (CardNotFoundException cardException) {
			System.out.println(cardException.getMessage());
			code = 400;
			serverMessage = cardException.getMessage();
		}
		catch (BakiyeYetersizException bakiyeException) {
			System.out.println(bakiyeException.getMessage());
			code = 402;
			serverMessage = bakiyeException.getMessage();
		}catch (Exception e){
			System.out.println(e.getMessage());
			code = 500;
			serverMessage = e.getMessage();
		}
		responseDto = BaseResponseDto.<VwTapping>builder()
		                          .code(code).data(null).success(false).message(serverMessage).build();
		return ResponseEntity.badRequest().body(responseDto);
	}
	


}