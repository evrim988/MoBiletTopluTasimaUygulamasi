package com.eergun.mobilet.repository;

import com.eergun.mobilet.dto.response.TransactionDateDto;
import com.eergun.mobilet.entity.Tapping;
import com.eergun.mobilet.view.VwDirectionAndVehicleSerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TappingRepository extends JpaRepository<Tapping, Long> {
	
	TransactionDateDto findTopByCardSerialNumberAndIsTransferFalseOrderByTransactionDateDesc(String cardSerialNumber);

//	//JPQL
//	@Query("select t.vehicleSerialNo  from Tapping t where t.cardSerialNumber=?1 AND t.transactionDate= ?2")
//	List<String> findVehicleSerialNoListByTransactionDate(String cardSerialNumber,Long transactionDate);
	
	@Query("select new com.eergun.mobilet.view.VwDirectionAndVehicleSerialNumber(t.vehicleSerialNo,t.direction) from Tapping t" +
			" where t" +
			".cardSerialNumber=?1 AND t.transactionDate= ?2  ")
	List<VwDirectionAndVehicleSerialNumber> findDirectionAndVehicleSerialNoByTransactionDate (String cardSerialNumber,Long transactionDate);
	
	
	
}