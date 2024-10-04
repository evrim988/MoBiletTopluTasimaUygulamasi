package com.eergun.mobilet.controller;

import com.eergun.mobilet.entity.card.AnonymousCard;
import com.eergun.mobilet.service.AnonymousCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/anonim")
public class AnonymousCardController {
	
	private final AnonymousCardService anonymousCardService;
	
	@GetMapping("/kart")
	public AnonymousCard getAnonymousCard() {
		
		return anonymousCardService.findOptionalBySerialNumber("4e9658a9-1e39-486f-a71e-97fee70798").get();
	}
}