package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
	
	@Query("select s.stationName from Station s where s.id=?1")
	String findStationNameById(long id);
}