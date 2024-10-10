package com.eergun.mobilet.repository;

import com.eergun.mobilet.dto.response.TransactionDateDto;
import com.eergun.mobilet.entity.Tapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TappingRepository extends JpaRepository<Tapping, Long> {
	
	TransactionDateDto findTopByCardSerialNumberAndIsTransferFalseOrderByTransactionDateDesc(String cardSerialNumber);
	
}