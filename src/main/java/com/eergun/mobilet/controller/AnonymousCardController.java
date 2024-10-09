package com.eergun.mobilet.controller;

import static com.eergun.mobilet.constants.RestApis.*;
import com.eergun.mobilet.entity.card.AnonymousCard;
import com.eergun.mobilet.service.AnonymousCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ANONYMOUS)
public class AnonymousCardController {
	
	private final AnonymousCardService anonymousCardService;
	
}