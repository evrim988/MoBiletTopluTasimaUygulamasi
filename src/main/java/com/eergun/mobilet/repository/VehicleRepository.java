package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Boolean existsByVehicleSerialNo(String vehicleSerialNo);

}