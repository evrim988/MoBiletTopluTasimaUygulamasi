package com.eergun.mobilet.controller;


import com.eergun.mobilet.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {
	private final VehicleService vehicleService;
}