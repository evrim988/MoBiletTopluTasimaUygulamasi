package com.eergun.mobilet.service;

import com.eergun.mobilet.dto.request.TapRequestDto;
import com.eergun.mobilet.dto.response.TransactionDateDto;
import com.eergun.mobilet.entity.Tapping;
import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.entity.enums.Direction;
import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.exception.MobiletException;
import com.eergun.mobilet.mapper.TappingMapper;
import com.eergun.mobilet.repository.TappingRepository;
import com.eergun.mobilet.entity.enums.VehicleType;
import com.eergun.mobilet.utility.time.TimeConvertor;
import com.eergun.mobilet.view.VwDirectionAndVehicleSerialNumber;
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
	private final StationService stationService;
	
	public VwTapping tapTheCard(TapRequestDto dto) {
		if(!vehicleService.existsByVehicalSerialNo(dto.vehicleSerialNo())) {
			throw new MobiletException(ErrorType.VEHICLE_NOT_FOUND);
		}
		String cardSerialNumber = dto.cardSerialNumber();
		String vehicleSerialNo = dto.vehicleSerialNo();
		Card card = cardService.findBySerialNumber(cardSerialNumber);
		Long transactionDate = getLatestTransactionDate(cardSerialNumber);
		
		boolean isTransfer = isTransfer(cardSerialNumber, vehicleSerialNo, transactionDate, dto.direction());
		
		VehicleType vehicleType = dto.vehicleType();
		card.tapTheCard(vehicleType, isTransfer);
		cardService.save(card);
		var tapping = TappingMapper.INSTANCE.fromTapRequestDto(dto);
		tapping.setIsTransfer(isTransfer);
		tappingRepository.save(tapping);
		return VwTapping.builder().message((isTransfer? "transfer->": "") +
	                                   card.getRemainingUsageMessage()).stationName(stationService.findStationNameById(dto.stationId())).build();
	}
	
	private boolean isTransfer(String cardSerialNumber, String vehicleSerialNo, Long transactionDate, Direction direction) {
		return isTransactionTransferTypeByTime(transactionDate) && isTransferByVehicle(cardSerialNumber,
		                                                                               vehicleSerialNo, direction);
	}
	
	private boolean isTransferByVehicle(String cardSerialNumber, String vehicleSerialNo, Direction direction) {
		Long transactionDate = getLatestTransactionDate(cardSerialNumber);
		List<VwDirectionAndVehicleSerialNumber> viewList = getVehicleSerialNoListByTransactionDate(cardSerialNumber,
		                                                                                    transactionDate);
		
		for(VwDirectionAndVehicleSerialNumber vw : viewList) {
			if(vw.getVehicleSerialNo().equals(vehicleSerialNo) && vw.getDirection().equals(direction)) {
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

	public List<VwDirectionAndVehicleSerialNumber> getVehicleSerialNoListByTransactionDate(String cardSerialNumber, Long transactionDate){
		return tappingRepository.findDirectionAndVehicleSerialNoByTransactionDate(cardSerialNumber,transactionDate);
	}
	
	public boolean isVehicleStationCorrect(Long stationId, List<Long>){
	
	}
	
}