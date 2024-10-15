package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.entity.BaseEntity;

import com.eergun.mobilet.entity.enums.VehicleType;
import com.eergun.mobilet.exception.MobiletException;
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
	@GeneratedValue(strategy = GenerationType.UUID)
	String serialNumber;
	
	public abstract void tapTheCard(VehicleType vehicleType,Boolean isTransfer);
	public abstract String getRemainingUsageMessage();



	
	
	// public abstract void pay();
}