package com.eergun.mobilet.entity;

import com.eergun.mobilet.entity.enums.Direction;
import com.eergun.mobilet.entity.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tbltapping")
public class Tapping extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String cardSerialNumber;
	@Enumerated(EnumType.STRING)
	VehicleType vehicleType;
	String vehicleSerialNo;
	Boolean isTransfer;
	@Builder.Default
	Long transactionDate = System.currentTimeMillis();
	Long stationId;
	@Enumerated(EnumType.STRING)
	Direction direction;
	
}