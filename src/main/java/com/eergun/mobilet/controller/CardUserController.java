package com.eergun.mobilet.controller;

import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.service.CardUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}