package com.eergun.mobilet.service;

import com.eergun.mobilet.repository.CardWithDiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardWithDiscountService {
	private final CardWithDiscountRepository cardWithDiscountRepository;
}