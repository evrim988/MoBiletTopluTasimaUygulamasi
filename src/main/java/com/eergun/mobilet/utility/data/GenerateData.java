package com.eergun.mobilet.utility.data;

import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.entity.Vehicle;
import com.eergun.mobilet.entity.card.AnonymousCard;
import com.eergun.mobilet.entity.card.Card;
import com.eergun.mobilet.entity.card.CardWithDiscount;
import com.eergun.mobilet.repository.AnonymousCardRepository;
import com.eergun.mobilet.repository.CardUserRepository;
import com.eergun.mobilet.repository.VehicleRepository;
import com.eergun.mobilet.service.AnonymousCardService;
import com.eergun.mobilet.service.CardUserService;
import com.eergun.mobilet.utility.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Component
public class GenerateData implements ApplicationRunner {
	@Autowired
	private AnonymousCardRepository anonymousCardRepository;
	@Autowired
	private CardUserRepository cardUserRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		createCard();
//		createCardUser();
//		createVehicle();
		
	}
	
	private void createCardUser() {
		CardUser cardUser = CardUser.builder().name("Emine").lastName("Karabolat").identityNo("1234").password("12345").build();
		CardUser cardUser1 = CardUser.builder().name("Emirhan").lastName("Ergün").identityNo("1235").password(
				"12345").adress("Çorlu").build();
		CardUser cardUser2 = CardUser.builder().name("Evrim").lastName("Çalışkan").identityNo("1236").password(
				"12345").build();
		CardUser cardUser3 = CardUser.builder().name("Murat").lastName("Saçak").identityNo("1237").password(
				"12345").build();
		
		cardUserRepository.saveAll(List.of(cardUser, cardUser1, cardUser2, cardUser3));
	}
	
	private void createCard() {
		for (int i = 0; i < 100; i++) {
			AnonymousCard anonymousCard = AnonymousCard.builder().serialNumber(UUID.randomUUID().toString()).build();
			anonymousCardRepository.save(anonymousCard);
		}
		
		}
		private void createVehicle(){
			Vehicle vehicle = Vehicle.builder().plateNo("41KS123").type(VehicleType.FERRY).build();
			Vehicle vehicle1 = Vehicle.builder().plateNo("01ADN190").type(VehicleType.BUS).build();
			Vehicle vehicle2 = Vehicle.builder().plateNo("59CRL124").type(VehicleType.FUNICULAR).build();
			Vehicle vehicle3 = Vehicle.builder().plateNo("16ACA420").type(VehicleType.METRO).build();
			Vehicle vehicle4 = Vehicle.builder().plateNo("34IST034").type(VehicleType.TRAM).build();
			
			vehicleRepository.saveAll(List.of(vehicle, vehicle1, vehicle2, vehicle3, vehicle4));
			
		}
		
	}