package com.eergun.mobilet.controller;

import com.eergun.mobilet.dto.response.BaseResponseDto;
import com.eergun.mobilet.exception.BakiyeYetersizException;
import static com.eergun.mobilet.constants.RestApis.*;

import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.exception.CardNotFoundException;
import com.eergun.mobilet.service.CardService;
import com.eergun.mobilet.utility.enums.VehicleType;
import com.eergun.mobilet.view.VwCard;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.validation.constraints.Size;
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
@RequestMapping(CARD)
public class CardController {
    private final CardService cardService;

    @GetMapping(GETALL)
    public ResponseEntity<BaseResponseDto<List<String>>> getAllCards() {
        List<String> serialNumberList = cardService.findAllSerialNumbers();
        try{
            return ResponseEntity.ok(BaseResponseDto.<List<String>>builder()
                                                    .code(200)
                                                    .data(serialNumberList)
                                                    .message("card view")
                                                    .success(true)
                                                    .build());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }


    @PostMapping(FINDBYCARDSERIALNUMBER)
    public ResponseEntity<Boolean> existsBySerialNumber(@Size(min = 36, max = 36) String serialNumber) {
        try{
            return ResponseEntity.ok(cardService.existsBySerialNumber(serialNumber));
        } catch (CardNotFoundException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}