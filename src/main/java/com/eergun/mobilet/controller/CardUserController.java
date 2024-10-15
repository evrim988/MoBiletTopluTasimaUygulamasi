package com.eergun.mobilet.controller;

import static com.eergun.mobilet.constants.RestApis.*;

import com.eergun.mobilet.dto.request.CardUserSaveRequestDto;
import com.eergun.mobilet.dto.response.BaseResponse;
import com.eergun.mobilet.service.CardUserService;
import com.eergun.mobilet.view.VwCardUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(CARDUSER)
@RestController
@RequiredArgsConstructor
public class CardUserController {
	private final CardUserService cardUserService;

	@PostMapping(ADD)
	public ResponseEntity<BaseResponse<VwCardUser>> addUser(@Valid @RequestBody CardUserSaveRequestDto dto) {
		VwCardUser vwCardUser = cardUserService.save(dto);
		return ResponseEntity.ok(BaseResponse.<VwCardUser>builder()
		                                     .message("user registered")
		                                     .code(200)
		                                     .data(vwCardUser)
		                                     .success(true).build());
	}
}