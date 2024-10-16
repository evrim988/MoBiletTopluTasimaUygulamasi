package com.eergun.mobilet.entity;

import com.eergun.mobilet.entity.enums.Direction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblvehicleline")
public class VehicleLine extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	@ElementCollection
	List<Long> stationId;
	@Enumerated(EnumType.STRING)
	Direction direction;
	

}