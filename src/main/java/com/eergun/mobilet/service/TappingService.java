package com.eergun.mobilet.service;

import com.eergun.mobilet.dto.request.TapRequestDto;
import com.eergun.mobilet.dto.response.TransactionDateDto;
import com.eergun.mobilet.entity.Tapping;
import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.exception.MobiletException;
import com.eergun.mobilet.mapper.TappingMapper;
import com.eergun.mobilet.repository.TappingRepository;
import com.eergun.mobilet.entity.enums.VehicleType;
import com.eergun.mobilet.utility.time.TimeConvertor;
import com.eergun.mobilet.view.VwTapping;
import static com.eergun.mobilet.constants.FieldConstants.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TappingService {
	private final TappingRepository tappingRepository;
	private final CardService cardService;
	private final VehicleService vehicleService;
	
	public VwTapping tapTheCard(TapRequestDto dto) {
		if(!vehicleService.existsByVehicalSerialNo(dto.vehicleSerialNo())) {
			throw new MobiletException(ErrorType.VEHICLE_NOT_FOUND);
		}
		String cardSerialNumber = dto.cardSerialNumber();
		String vehicleSerialNo = dto.vehicleSerialNo();
		Card card = cardService.findBySerialNumber(cardSerialNumber);
		Long transactionDate = getLatestTransactionDate(cardSerialNumber);
		
		boolean isTransfer = isTransfer(cardSerialNumber, vehicleSerialNo, transactionDate);
		
		VehicleType vehicleType = dto.vehicleType();
		card.tapTheCard(vehicleType, isTransfer);
		cardService.save(card);
		var tapping = TappingMapper.INSTANCE.fromTapRequestDto(dto);
		tapping.setIsTransfer(isTransfer);
		tappingRepository.save(tapping);
		return VwTapping.builder().message((isTransfer? "transfer->": "") +
	                                   card.getRemainingUsageMessage()).build();
	}
	
	private boolean isTransfer(String cardSerialNumber, String vehicleSerialNo, Long transactionDate) {
		return isTransactionTransferTypeByTime(transactionDate) && isTransferByVehicle(cardSerialNumber, vehicleSerialNo);
	}
	
	private boolean isTransferByVehicle(String cardSerialNumber, String vehicleSerialNo) {
		Long transactionDate = getLatestTransactionDate(cardSerialNumber);
		List<String> vehicleNoList = getVehicleSerialNoListByTransactionDate(cardSerialNumber, transactionDate);
		
		for(String v : vehicleNoList) {
			if(v.equals(vehicleSerialNo)) {
				return false;
			}
		}
		return true;
	}
	
	public Long getLatestTransactionDate(String cardSerialNumber){
		TransactionDateDto transactionDateDto =
				tappingRepository.findTopByCardSerialNumberAndIsTransferFalseOrderByTransactionDateDesc(cardSerialNumber);
		if(transactionDateDto==null){
			return 0L;
		}
		return transactionDateDto.getTransactionDate();

	}
	
	public boolean isTransactionTransferTypeByTime(long transactionDate){
		Long transferTime = TimeConvertor
				.millisToMinutes((System.currentTimeMillis())-transactionDate);
		System.out.println(transferTime);
        return transferTime < maxTransferTime;
    }

	public List<String> getVehicleSerialNoListByTransactionDate(String cardSerialNumber, Long transactionDate){
		return tappingRepository.findVehicleSerialNoListByTransactionDate(cardSerialNumber,transactionDate);
	}
	
}