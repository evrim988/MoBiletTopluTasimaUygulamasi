package com.eergun.mobilet.controller;

import com.eergun.mobilet.exception.CardNotFoundException;
import static com.eergun.mobilet.constants.RestApis.*;
import com.eergun.mobilet.dto.request.AddMoneyRequestDto;
import com.eergun.mobilet.entity.card.AnonymousCard;
import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.entity.card.CardWithBalance;
import com.eergun.mobilet.service.CardWithBalanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CARDWITHBALANCE)
@RequiredArgsConstructor
public class CardWithBalanceController {

    private final CardWithBalanceService cardWithBalanceService;

    @PostMapping(ADDMONEY)
    public ResponseEntity<CardWithBalance> makeDeposit(@RequestBody @Valid AddMoneyRequestDto addMoneyRequestDto) {
        try {
            CardWithBalance cardWithBalance = cardWithBalanceService.findBySerialNumber(addMoneyRequestDto);
            return ResponseEntity.ok(cardWithBalance);
        }
        catch (CardNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
}