package com.eergun.mobilet.service;

import com.eergun.mobilet.repository.CardUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardUserService {
	private final CardUserRepository cardUserRepository;
}