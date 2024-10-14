package com.eergun.mobilet.controller;

import com.eergun.mobilet.dto.response.BaseResponseDto;

import static com.eergun.mobilet.constants.RestApis.*;


import com.eergun.mobilet.service.CardService;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(CARD)
public class CardController {
    private final CardService cardService;

    @GetMapping(GETALL)
    public ResponseEntity<BaseResponseDto<List<String>>> getAllCards() {
        List<String> serialNumberList = cardService.findAllSerialNumbers();
        try {
            return ResponseEntity.ok(BaseResponseDto.<List<String>>builder()
                    .code(200)
                    .data(serialNumberList)
                    .message("card view")
                    .success(true)
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }


    @PostMapping(FINDBYCARDSERIALNUMBER)
    public ResponseEntity<Boolean> existsBySerialNumber(@Size(min = 36, max = 36) String serialNumber) {
        return ResponseEntity.ok(cardService.existsBySerialNumber(serialNumber));
    }

}