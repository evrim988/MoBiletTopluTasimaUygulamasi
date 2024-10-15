package com.eergun.mobilet.controller;

import static com.eergun.mobilet.constants.RestApis.*;

import com.eergun.mobilet.dto.response.BaseResponse;
import com.eergun.mobilet.service.AnonymousCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ANONYMOUS)
public class AnonymousCardController {
	private final AnonymousCardService anonymousCardService;
	
	@PostMapping(ADD)
	public ResponseEntity<BaseResponse<Boolean>> addCard(){
		anonymousCardService.save();
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                                     .data(true).code(200).message("kart basariyla olusturuldu")
			                         .success(true).build());
	}
	
}