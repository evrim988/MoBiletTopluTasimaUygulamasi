package com.eergun.mobilet.controller;

import static com.eergun.mobilet.constants.RestApis.*;
import static com.eergun.mobilet.constants.RestApis.LOGIN;

import com.eergun.mobilet.dto.request.CardUserSaveRequestDto;
import com.eergun.mobilet.dto.request.DoLoginRequestDto;
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

	@PostMapping(REGISTER)
	public ResponseEntity<BaseResponse<VwCardUser>> addUser(@Valid @RequestBody CardUserSaveRequestDto dto) {
		VwCardUser vwCardUser = cardUserService.register(dto);
		return ResponseEntity.ok(BaseResponse.<VwCardUser>builder()
		                                     .message("user registered")
		                                     .code(200)
		                                     .data(vwCardUser)
		                                     .success(true).build());
	}

	@PostMapping(LOGIN)
	public ResponseEntity<BaseResponse<String>> doLogin(@Valid @RequestBody DoLoginRequestDto dto) {
		return ResponseEntity.ok(BaseResponse.<String>builder()
				.success(true)
				.code(200)
				.message("Giriş Başarılı")
				.data(cardUserService.doLogin(dto))
				.build());
	}

	@GetMapping(GETPROFILE)
	public ResponseEntity<BaseResponse<VwCardUser>> getMyProfile(String token){
		return ResponseEntity.ok(BaseResponse.<VwCardUser>builder()
						.success(true)
						.code(200)
						.message("Profil bilgileriniz başarılı şekilde listelendi.")
						.data(cardUserService.getMyProfile(token))
				.build());
	}
}