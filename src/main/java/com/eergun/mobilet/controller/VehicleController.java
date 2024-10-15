package com.eergun.mobilet.controller;


import static com.eergun.mobilet.constants.RestApis.*;

import com.eergun.mobilet.dto.request.AddVehicleRequestDto;
import com.eergun.mobilet.dto.response.BaseResponse;
import com.eergun.mobilet.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(VEHICLE)
public class VehicleController {
	private final VehicleService vehicleService;
	
	@PostMapping(ADD)
	public ResponseEntity<BaseResponse<Boolean>> addVehicle(AddVehicleRequestDto dto){
		vehicleService.save(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                         .code(200).success(true).message("arac ekleme basarili")
                         .data(true).build());
	}
}