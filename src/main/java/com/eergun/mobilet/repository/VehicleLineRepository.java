package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.VehicleLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleLineRepository extends JpaRepository<VehicleLine, Long> {
	
	
	@Query("select vl.stationId   from VehicleLine vl where vl.id=?1")
	List<Long> findStationIdByVehicleLineId(Long vehicleLineId);
}