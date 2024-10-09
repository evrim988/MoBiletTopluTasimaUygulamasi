package com.eergun.mobilet.service;

import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.repository.CardRepository;
import com.eergun.mobilet.utility.enums.VehicleType;
import com.eergun.mobilet.view.VwCard;
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
    
    public Optional<Card> findBySerialNumber(String serialNumber) {
        return cardRepository.findOptionalBySerialNumber(serialNumber);
    }
}