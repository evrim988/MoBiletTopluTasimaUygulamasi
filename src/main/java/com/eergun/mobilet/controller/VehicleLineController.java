package com.eergun.mobilet.controller;

import com.eergun.mobilet.service.VehicleLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static  com.eergun.mobilet.constants.RestApis.*;

@RestController
@RequestMapping(VEHICLE_LINE)

public class VehicleLineController {
	private final VehicleLineService vehicleLineService;
	
	public VehicleLineController(VehicleLineService vehicleLineService) {
		this.vehicleLineService = vehicleLineService;
	}
}