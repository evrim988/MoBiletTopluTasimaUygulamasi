package com.eergun.mobilet.service;

import com.eergun.mobilet.dto.request.AddMoneyRequestDto;
import com.eergun.mobilet.entity.card.CardWithBalance;
import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.exception.MobiletException;
import com.eergun.mobilet.repository.CardWithBalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardWithBalanceService {

    private final CardWithBalanceRepository cardWithBalanceRepository;

    public void makeDeposit(AddMoneyRequestDto addMoneyRequestDto) {
        Optional<CardWithBalance> optionalBySerialNumber =
                cardWithBalanceRepository.findOptionalBySerialNumber(addMoneyRequestDto.serialNumber());
        
        if (optionalBySerialNumber.isPresent()) {
            CardWithBalance cardWithBalance = optionalBySerialNumber.get();
            cardWithBalance.setBalance(cardWithBalance.getBalance() + addMoneyRequestDto.amount());
            cardWithBalanceRepository.save(cardWithBalance);
        }
        else throw new MobiletException(ErrorType.CARD_NOT_FOUND);
    }
}