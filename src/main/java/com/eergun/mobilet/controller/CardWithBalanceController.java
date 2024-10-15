package com.eergun.mobilet.controller;


import static com.eergun.mobilet.constants.RestApis.*;

import com.eergun.mobilet.dto.request.AddMoneyRequestDto;
import com.eergun.mobilet.dto.response.BaseResponse;
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

    @PostMapping(PAY)
    public ResponseEntity<BaseResponse<Boolean>> makeDeposit(@RequestBody @Valid AddMoneyRequestDto addMoneyRequestDto) {
        cardWithBalanceService.makeDeposit(addMoneyRequestDto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                                         .success(true)
                                         .code(200)
                                         .message("para yukleme basarili")
                                         .data(true).build());
    }
}