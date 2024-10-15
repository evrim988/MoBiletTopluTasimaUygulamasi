package com.eergun.mobilet.service;

import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.exception.MobiletException;
import com.eergun.mobilet.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    

    public List<String> findAllSerialNumbers(){
        return cardRepository.findAllAsSerialNumber();
    }

    
    public void save(Card card){
        cardRepository.save(card);
    }
    
    
    public Boolean existsBySerialNumber(String serialNumber) {
        return cardRepository.existsCardBySerialNumber(serialNumber);
    }
    
    public Card findBySerialNumber(String serialNumber) {
        Optional<Card> optCard = cardRepository.findOptionalBySerialNumber(serialNumber);
        if (optCard.isPresent()) {
            return optCard.get();
        }
        throw new MobiletException(ErrorType.CARD_NOT_FOUND);
    }
}