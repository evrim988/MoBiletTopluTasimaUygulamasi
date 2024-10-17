package com.eergun.mobilet.service;

import com.eergun.mobilet.repository.VehicleLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleLineService {
    private final VehicleLineRepository vehicleLineRepository;

    public VehicleLineService(VehicleLineRepository vehicleLineRepository) {
        this.vehicleLineRepository = vehicleLineRepository;
    }

    public List<Long> findStationIdByVehicleLineId(Long vehicleLineId){
        return vehicleLineRepository.findStationIdByVehicleLineId(vehicleLineId);
    }
}