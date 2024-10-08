package com.eergun.mobilet.controller;

import com.eergun.mobilet.entity.card.AnonymousCard;
import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.service.AnonymousCardService;
import com.eergun.mobilet.utility.enums.VehicleType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/anonim")
public class AnonymousCardController {
	
	private final AnonymousCardService anonymousCardService;



	@GetMapping("/get-all")
	public List<AnonymousCard> getAnonymousCards(){
		return anonymousCardService.findAll();
	}



	@PostMapping
	public void paraYukle(AnonymousCard anonymousCard,Integer money){
		anonymousCard.setBalance(anonymousCard.getBalance()+money);
	}






}