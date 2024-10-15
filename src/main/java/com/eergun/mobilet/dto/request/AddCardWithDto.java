package com.eergun.mobilet.dto.request;

import com.eergun.mobilet.entity.enums.CardType;

public record AddCardWithDto(
		Long cardUserId,
		CardType cardType
) {
}