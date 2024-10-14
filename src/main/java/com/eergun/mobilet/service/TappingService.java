package com.eergun.mobilet.service;

import com.eergun.mobilet.dto.request.TapRequestDto;
import com.eergun.mobilet.dto.response.BaseResponseDto;
import com.eergun.mobilet.dto.response.TransactionDateDto;
import com.eergun.mobilet.entity.Tapping;
import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.exception.CardNotFoundException;
import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.exception.VehicleNotFoundException;
import com.eergun.mobilet.repository.TappingRepository;
import com.eergun.mobilet.utility.enums.VehicleType;
import com.eergun.mobilet.utility.time.TimeConvertor;
import com.eergun.mobilet.view.VwTapping;
import static com.eergun.mobilet.constants.FieldConstants.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TappingService {
	private final TappingRepository tappingRepository;
	private final CardService cardService;
	private final VehicleService vehicleService;
	
	public BaseResponseDto<VwTapping> tapTheCard(TapRequestDto request) {

		if(!vehicleService.existsByVehicalSerialNo(request.getVehicleSerialNo())) {
			throw new VehicleNotFoundException(ErrorType.VEHICLE_NOT_FOUND);
		}

		String cardSerialNumber = request.getSerialNumber();
		String vehicleSerialNo = request.getVehicleSerialNo();
		Optional<Card> optCard = cardService.findBySerialNumber(cardSerialNumber);

		if (optCard.isEmpty()) {
			throw new CardNotFoundException(ErrorType.CARD_NOT_FOUND);
		}
		else {
			Card card = optCard.get();

			Long transactionDate = getLatestTransactionDate(cardSerialNumber);

			boolean isTransfer = isTransactionTransferType(transactionDate);

			if(isTransfer) {
				List<String> vehicleNoList = getVehicleSerialNoListByTransactionDate(cardSerialNumber, transactionDate);
				vehicleNoList.forEach(System.out::println);
				for(String v : vehicleNoList) {
					if(v.equals(vehicleSerialNo)) {
						isTransfer = false;
						break;
					}
				}
			}

			VehicleType vehicleType = request.getVehicleType();
			card.tapTheCard(vehicleType,isTransfer);
			String message = isTransfer ? ("Transfer->"+card.getRemainingUsageMessage()) : (card.getRemainingUsageMessage());
			cardService.save(card);
			tappingRepository.save(Tapping.builder()
					                       .vehicleType(vehicleType)
								           .isTransfer(isTransfer)
					                       .cardSerialNumber(cardSerialNumber)
										   .vehicleSerialNo(vehicleSerialNo)
					                       .build());
			return BaseResponseDto.<VwTapping>builder().code(200)
			                      .data(VwTapping.builder().message(message).build())
			                      .message("tapping process successful").success(true).build();
		}


	}
	
	public Long getLatestTransactionDate(String cardSerialNumber){
		TransactionDateDto transactionDateDto =
				tappingRepository.findTopByCardSerialNumberAndIsTransferFalseOrderByTransactionDateDesc(cardSerialNumber);
		if(transactionDateDto==null){
			return 0L;
		}
		return transactionDateDto.getTransactionDate();

	}



	public boolean isTransactionTransferType(long transactionDate){

		Long transferTime = TimeConvertor
				.millisToMinutes((System.currentTimeMillis())-transactionDate);
		System.out.println(transferTime);
        return transferTime < maxTransferTime;
    }

	public List<String> getVehicleSerialNoListByTransactionDate(String cardSerialNumber, Long transactionDate){
		return tappingRepository.findVehicleSerialNoListByTransactionDate(cardSerialNumber,transactionDate);
	}


	
}