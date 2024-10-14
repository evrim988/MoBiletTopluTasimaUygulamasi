package com.eergun.mobilet.controller;

import com.eergun.mobilet.dto.request.TapRequestDto;
import com.eergun.mobilet.dto.response.BaseResponseDto;
import com.eergun.mobilet.dto.response.TransactionDateDto;
import com.eergun.mobilet.entity.Tapping;
import com.eergun.mobilet.service.TappingService;
import com.eergun.mobilet.view.VwTapping;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.eergun.mobilet.constants.RestApis.*;

@RestController
@RequestMapping(TAPPING)
@RequiredArgsConstructor
public class TappingController {
    private final TappingService tappingService;

    @PostMapping(ODEME)
    @ResponseBody
    public ResponseEntity<BaseResponseDto<VwTapping>> tapTheCard(@Valid @RequestBody TapRequestDto request) {
        BaseResponseDto<VwTapping> responseDto;
        String serverMessage = null;
        Integer code = null;

        responseDto = tappingService.tapTheCard(request);
        return ResponseEntity.ok(responseDto);

    }


}