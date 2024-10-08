package com.eergun.mobilet.controller;

import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.service.CardUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class CardUserController {
	private final CardUserService cardUserService;
	
	@GetMapping("/users-{name}")
	public List<CardUser> getUsers(@PathVariable String name) {
		return cardUserService.findAllByNameContaining(name);
	}

	@PostMapping("/add")
	public String addUser(@Valid @RequestBody CardUser cardUser) {
		cardUserService.save(cardUser);
		return "Kullanıcı başarıyla kaydedildi.";
	}
}