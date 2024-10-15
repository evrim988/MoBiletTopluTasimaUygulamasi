package com.eergun.mobilet.controller;

import com.eergun.mobilet.dto.response.BaseResponse;

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
    public ResponseEntity<BaseResponse<List<String>>> getAllCards() {
        return ResponseEntity.ok(BaseResponse.<List<String>>builder()
                                             .code(200)
                                             .data(cardService.findAllSerialNumbers())
                                             .message("card view")
                                             .success(true).build());
        
    }
    @PostMapping(FINDBYCARDSERIALNUMBER)
    public ResponseEntity<BaseResponse<Boolean>> existsBySerialNumber(@Size(min = 36, max = 36) String serialNumber) {
        return ResponseEntity.ok(BaseResponse.<Boolean>builder().success(true).code(200)
                                         .message("seri numarası bulundu")
                                         .data(cardService.existsBySerialNumber(serialNumber))
                                         .build());
    }
}