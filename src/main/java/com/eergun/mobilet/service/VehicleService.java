package com.eergun.mobilet.service;


import com.eergun.mobilet.dto.request.AddVehicleRequestDto;
import com.eergun.mobilet.mapper.VehicleMapper;
import com.eergun.mobilet.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {
	private final VehicleRepository vehicleRepository;

	public Boolean existsByVehicalSerialNo(String vehicleSerialNo){
		return vehicleRepository.existsByVehicleSerialNo(vehicleSerialNo);
	}
	
	public void save(AddVehicleRequestDto dto) {
		vehicleRepository.save(VehicleMapper.INSTANCE.fromAddRequest(dto));
	}
}