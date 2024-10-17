package com.eergun.mobilet.entity;

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
@Table(name = "tblvehicle")
public class Vehicle extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long tappingMachinId;
	Long vehicleLineId;

	String vehicleSerialNo;
	@Enumerated(EnumType.STRING)
	VehicleType type;

	

}