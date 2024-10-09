package com.eergun.mobilet.controller;

import static com.eergun.mobilet.constants.RestApis.*;
import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.service.CardUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(CARDUSER)
@RestController
@RequiredArgsConstructor
public class CardUserController {
	private final CardUserService cardUserService;


	@PostMapping(ADDUSER)
	public String addUser(@Valid @RequestBody CardUser cardUser) {
		cardUserService.save(cardUser);
		return "Kullanıcı başarıyla kaydedildi.";
	}
}