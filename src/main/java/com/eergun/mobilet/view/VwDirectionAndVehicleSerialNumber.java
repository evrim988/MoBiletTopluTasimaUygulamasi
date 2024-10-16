package com.eergun.mobilet.view;

import com.eergun.mobilet.entity.enums.Direction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VwDirectionAndVehicleSerialNumber {
	String vehicleSerialNo;
	Direction direction;
}