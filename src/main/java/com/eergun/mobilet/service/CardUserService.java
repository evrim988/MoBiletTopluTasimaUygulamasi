package com.eergun.mobilet.service;

import com.eergun.mobilet.dto.request.CardUserSaveRequestDto;
import com.eergun.mobilet.dto.request.DoLoginRequestDto;
import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.exception.MobiletException;
import com.eergun.mobilet.mapper.CardUserMapper;
import com.eergun.mobilet.repository.CardUserRepository;
import com.eergun.mobilet.utility.JwtManager;
import com.eergun.mobilet.view.VwCardUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardUserService{
	private final CardUserRepository cardUserRepository;
	private final JwtManager jwtManager;
	
	public List<CardUser> findAllByNameContaining(String name){
		return cardUserRepository.findAllByNameContainingIgnoreCase(name);
	}

	public VwCardUser register(CardUserSaveRequestDto dto) {
		CardUser cardUser = CardUserMapper.INSTANCE.fromCardUserSaveRequestDto(dto);
		cardUserRepository.save(cardUser);
		return VwCardUser.builder()
                           .phone(cardUser.getPhone())
                           .adress(cardUser.getAdress())
                           .lastName(cardUser.getLastName())
                           .name(cardUser.getName())
                             .build();
	}
	
	public boolean existsById(Long userId) {
		return cardUserRepository.existsById(userId);
	}

	public String doLogin(@Valid DoLoginRequestDto doLoginRequestDto){
		Optional<CardUser> optionalByUser = cardUserRepository.findOptionalByEmailAndPassword(doLoginRequestDto.email(), doLoginRequestDto.password());
		if(optionalByUser.isEmpty())
			throw new MobiletException(ErrorType.INVALID_EMAIL_OR_PASSWORD);
		String token = jwtManager.createToken(optionalByUser.get().getId());
		return token;
	}

	public VwCardUser getMyProfile(String token) {
		Optional<Long> cardUserId = jwtManager.validateToken(token);
		if(cardUserId.isEmpty())
			throw new MobiletException(ErrorType.INVALID_TOKEN);

		Optional<CardUser> optionalCardUser = cardUserRepository.findById(cardUserId.get());
		if(optionalCardUser.isEmpty())
			throw new MobiletException(ErrorType.USER_NOT_FOUND);
		VwCardUser vwCardUser = CardUserMapper.INSTANCE.fromVwCardUser(optionalCardUser.get());
		return vwCardUser;
	}
}