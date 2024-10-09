package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.entity.BaseEntity;

import com.eergun.mobilet.exception.BakiyeYetersizException;
import com.eergun.mobilet.utility.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "entityType")
@Entity
@Table(name = "tblcard")
public abstract class Card extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column
	String serialNumber;
	
	public abstract void tapTheCard(VehicleType vehicleType) throws BakiyeYetersizException;
	public abstract String getRemainingUsageMessage();



	
	
	// public abstract void pay();
}