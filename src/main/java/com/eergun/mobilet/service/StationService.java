package com.eergun.mobilet.service;

import com.eergun.mobilet.repository.StationRepository;
import org.springframework.stereotype.Service;

@Service
public class StationService {
	private StationRepository stationRepository;
	public StationService(StationRepository stationRepository) {
		this.stationRepository = stationRepository;
	}
	public String findStationNameById(Long id) {
		return stationRepository.findStationNameById(id);
	}
	
}