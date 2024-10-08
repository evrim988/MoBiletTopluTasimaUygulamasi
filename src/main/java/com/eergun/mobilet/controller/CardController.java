package com.eergun.mobilet.controller;

import com.eergun.mobilet.Exception.BakiyeYetersizException;
import com.eergun.mobilet.entity.card.AnonymousCard;
import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.service.CardService;
import com.eergun.mobilet.utility.enums.VehicleType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    @GetMapping("/get-all")
    public List<Card> getAnonymousCards() {
        return cardService.findAll();
    }


    @PostMapping("/")
    public Card getCardByUser(String serialNumber) {
        return cardService.findOptionalBySerialNumber(serialNumber);
    }

    @PostMapping("/money")
    public Card makeDeposit(String serialNumber, Double amount) {
        Card card = getCardByUser(serialNumber);
        System.out.println(card);
        if (card != null) {
            if (card instanceof AnonymousCard) {
                ((AnonymousCard) card).setBalance(((AnonymousCard) card).getBalance() + amount);
                cardService.save(card);
            }
        }
        return card;
    }

//    @PostMapping("/odeme")
//    @ResponseBody
//    public String tapTheCard(String serialNumber, VehicleType vehicleType){
//        Card card =  cardService.tapTheAnonymousCard(serialNumber,vehicleType);
//        cardService.save(card);
//        System.out.println("Ödeme gerçekleştirildi. Kalan bakiye: "+card.getRemainingBalance());
//        return "redirect:/card/success";
//    }

    @PostMapping("/odeme")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> tapTheCard(String serialNumber, VehicleType vehicleType) {

        Card card;
        try {
            card = cardService.tapTheAnonymousCard(serialNumber, vehicleType);
        } catch (BakiyeYetersizException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
        cardService.save(card);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("tr", "TR"));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Ödeme gerçekleştirildi.");
        response.put("remainingBalance", currencyFormat.format(card.getRemainingBalance()));
        response.put("vehicleType", vehicleType.toString());


        return ResponseEntity.ok(response);
    }

    @GetMapping("/odeme")
    public String successMessage(Card card) {
        return "Ödeme gerçekleştirildi. Kalan bakiye:" + card.getRemainingBalance();
    }


}
