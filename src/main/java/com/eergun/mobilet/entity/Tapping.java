package com.eergun.mobilet.entity;

import com.eergun.mobilet.utility.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


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
	@Builder.Default
	Long transactionDate = System.currentTimeMillis();
	VehicleType vehicleType;
	String plateNo;
	Boolean isTransfer;
	
	
}