package com.eergun.mobilet.service;

import com.eergun.mobilet.repository.AnonymousCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnonymousCardService{
	private final AnonymousCardRepository anonymousCardRepository;
	
}