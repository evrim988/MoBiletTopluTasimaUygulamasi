package com.eergun.mobilet.service;

import com.eergun.mobilet.Exception.UserNotFoundException;
import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.repository.CardRepository;
import com.eergun.mobilet.utility.enums.VehicleType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public Card findOptionalBySerialNumber(String serialNumber){
        if(cardRepository.findOptionalBySerialNumber(serialNumber).isPresent()){
            return cardRepository.findOptionalBySerialNumber(serialNumber).get();
        }
        throw new UserNotFoundException();
    }

    public List<Card> findAll(){
        return cardRepository.findAll();
    }



    public void save(Card card){
        cardRepository.save(card);
    }

    public Card tapTheAnonymousCard(String serialNo, VehicleType vehicleType) {
        Optional<Card> cardOptional = cardRepository.findOptionalBySerialNumber(serialNo);
        if(cardOptional.isPresent()){
            Card card = cardOptional.get();
            card.tapTheCard(vehicleType);
            return card;
        }
        return null;
    }







}
