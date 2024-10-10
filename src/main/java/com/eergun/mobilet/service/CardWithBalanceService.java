package com.eergun.mobilet.service;

import com.eergun.mobilet.exceptions.CardNotFoundException;
import com.eergun.mobilet.dto.request.AddMoneyRequestDto;
import com.eergun.mobilet.entity.card.CardWithBalance;
import com.eergun.mobilet.repository.CardWithBalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardWithBalanceService {

    private final CardWithBalanceRepository cardWithBalanceRepository;

    public CardWithBalance findBySerialNumber(AddMoneyRequestDto addMoneyRequestDto) {
        Optional<CardWithBalance> optionalBySerialNumber = cardWithBalanceRepository.findOptionalBySerialNumber(addMoneyRequestDto.getSerialNumber());
        if (optionalBySerialNumber.isPresent()) {
            CardWithBalance cardWithBalance = optionalBySerialNumber.get();
            cardWithBalance.setBalance(cardWithBalance.getBalance() + addMoneyRequestDto.getAmount());
            cardWithBalanceRepository.save(cardWithBalance);
            return cardWithBalance;
        }
        throw new CardNotFoundException();
    }
}