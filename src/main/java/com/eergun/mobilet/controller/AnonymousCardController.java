package com.eergun.mobilet.controller;

import com.eergun.mobilet.service.AnonymousCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AnonymousCardController {
	private final AnonymousCardService anonymousCardService;
	
	public static void main(String[] args) {
		System.out.println("deneme");
	}
}