package com.eergun.mobilet.utility.data;

import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.entity.Station;
import com.eergun.mobilet.entity.Vehicle;
import com.eergun.mobilet.entity.VehicleLine;
import com.eergun.mobilet.entity.card.AnonymousCard;
import com.eergun.mobilet.repository.*;
import com.eergun.mobilet.entity.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
	@Autowired
	private StationRepository stationRepository;
	@Autowired
	private VehicleLineRepository vehicleLineRepository;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		createCard();
//		createCardUser();
//		createVehicle();
//		createStation();
// 	    createVehicleLine();

	}
	
	private void createVehicleLine() {
		for (int i = 0; i < 10; i++) {
			VehicleLine vehicleLine = VehicleLine.builder().stationId(List.of(i*10L,(i*10L)+1L,(i*10L)+2L,
			(i*10L)+3L,(i*10L)+4L,(i*10L)+5L,(i*10L)+6L,(i*10L)+7L,(i*10L)+8L,(i*10L)+9L)).name("Line"+i).build();
			vehicleLineRepository.save(vehicleLine);
		}
		
	}
	private void createStation() {
		for(int i = 0; i<100; i++){
			Station station = Station.builder().stationName("Station"+ i).stationNumber(10000+i).build();
			stationRepository.save(station);
		}
	}
	
	private void createCardUser() {
		CardUser cardUser = CardUser.builder().name("Emine").lastName("Karabolat").identityNo("12345678910").password("12345e").email("emine@gmail.com").build();
		CardUser cardUser1 = CardUser.builder().name("Emirhan").lastName("Ergün").identityNo("12354678910").email("asd123@gmail.com").password(
				"12345e").adress("Çorlu").build();
		CardUser cardUser2 = CardUser.builder().name("Evrim").lastName("Çalışkan").identityNo("12364578910").email("evrim@gmail.com").password(
				"12345C").build();
		CardUser cardUser3 = CardUser.builder().name("Murat").lastName("Saçak").identityNo("12374568910").password(
				"12345m").email("izmit_41@hotmail.com").build();
		
		CardUser cardUser4 = CardUser.builder().name("Mustafa").lastName("Sarı").identityNo("12374568911").password(
				"12345mm").email("izmit@hotmail.com").build();
		cardUserRepository.saveAll(List.of(cardUser, cardUser1, cardUser2, cardUser3, cardUser4));
	}
	
	private void createCard() {
		for (int i = 0; i < 100; i++) {
			AnonymousCard anonymousCard = AnonymousCard.builder().serialNumber(UUID.randomUUID().toString())
					.balance(1000).build();
			anonymousCardRepository.save(anonymousCard);
		}
		
		}
		private void createVehicle(){
			Vehicle vehicle1 =
					Vehicle.builder().vehicleSerialNo("F_1000").vehicleLineId(1L).type(VehicleType.FERRY).build();
			Vehicle vehicle2 =
					Vehicle.builder().vehicleSerialNo("F_1001").vehicleLineId(2L).type(VehicleType.FERRY).build();
			Vehicle vehicle3 =
					Vehicle.builder().vehicleSerialNo("B_1000").vehicleLineId(3L).type(VehicleType.BUS).build();
			Vehicle vehicle4 =
					Vehicle.builder().vehicleSerialNo("B_1001").vehicleLineId(4L).type(VehicleType.BUS).build();
			Vehicle vehicle5 =
					Vehicle.builder().vehicleSerialNo("FU_100").vehicleLineId(5L).type(VehicleType.FUNICULAR).build();
			Vehicle vehicle6 =
					Vehicle.builder().vehicleSerialNo("FU_101").vehicleLineId(6L).type(VehicleType.FUNICULAR).build();
			Vehicle vehicle7 =
					Vehicle.builder().vehicleSerialNo("M_1000").vehicleLineId(7L).type(VehicleType.METRO).build();
			Vehicle vehicle8 =
					Vehicle.builder().vehicleSerialNo("M_1001").vehicleLineId(8L).type(VehicleType.METRO).build();
			Vehicle vehicle9 =
					Vehicle.builder().vehicleSerialNo("T_1000").vehicleLineId(9L).type(VehicleType.TRAM).build();
			Vehicle vehicle10 =
					Vehicle.builder().vehicleSerialNo("T_1001").vehicleLineId(10L).type(VehicleType.TRAM).build();

			vehicleRepository.saveAll(List.of(vehicle1,vehicle2,vehicle3,vehicle4,vehicle5,vehicle6,vehicle7,vehicle8,
												vehicle9,vehicle10));
			
		}
		
	}