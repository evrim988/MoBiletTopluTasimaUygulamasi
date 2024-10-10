package com.eergun.mobilet.controller;

import static com.eergun.mobilet.constants.RestApis.*;

import com.eergun.mobilet.dto.request.CardUserSaveRequestDto;
import com.eergun.mobilet.dto.response.BaseResponseDto;
import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.entity.Person;
import com.eergun.mobilet.service.CardUserService;
import com.eergun.mobilet.view.VwCardUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(CARDUSER)
@RestController
@RequiredArgsConstructor
public class CardUserController {
	private final CardUserService cardUserService;

	@PostMapping(ADDUSER)
	public ResponseEntity<BaseResponseDto<VwCardUser>> addUser(@Valid @RequestBody CardUserSaveRequestDto dto) {
		try {
			VwCardUser vwCardUser = cardUserService.save(dto);
			return ResponseEntity.ok(BaseResponseDto.<VwCardUser>builder()
					                         .message("user registered")
					                         .code(200)
					                         .data(vwCardUser)
					                         .success(true).build());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().body(BaseResponseDto.<VwCardUser>builder()
					                                        .success(false)
					                                        .code(400)
					                                        .message("could not register user").build());
		}
	}
}