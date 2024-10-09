package com.eergun.mobilet.controller;


import static com.eergun.mobilet.constants.RestApis.*;
import com.eergun.mobilet.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(VEHICLE)
public class VehicleController {
	private final VehicleService vehicleService;
}