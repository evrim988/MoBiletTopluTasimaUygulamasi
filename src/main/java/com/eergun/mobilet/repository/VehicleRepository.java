package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Boolean existsByVehicleSerialNo(String vehicleSerialNo);
    
    
    @Query("select v.vehicleLineId from Vehicle v where v.id=?1")
    Long showStationById(Long id);

}