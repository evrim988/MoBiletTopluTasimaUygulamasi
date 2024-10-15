package com.eergun.mobilet.controller;

import com.eergun.mobilet.dto.request.TapRequestDto;
import com.eergun.mobilet.dto.response.BaseResponse;
import com.eergun.mobilet.service.TappingService;
import com.eergun.mobilet.view.VwTapping;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.eergun.mobilet.constants.RestApis.*;

@RestController
@RequestMapping(TAPPING)
@RequiredArgsConstructor
public class TappingController {
	private final TappingService tappingService;
	
	@PostMapping(ODEME)
	@ResponseBody
	public ResponseEntity<BaseResponse<VwTapping>> tapTheCard(@Valid @RequestBody TapRequestDto dto) {
		return ResponseEntity.ok(BaseResponse.<VwTapping>builder()
                                 .code(200).success(true).message("basma başarılı")
	                         .data(tappingService.tapTheCard(dto)).build());
	}
	
	
}