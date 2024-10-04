package com.eergun.mobilet.service;

import com.eergun.mobilet.entity.Tapping;
import com.eergun.mobilet.repository.TappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TappingService {
	private final TappingRepository tappingRepository;
}