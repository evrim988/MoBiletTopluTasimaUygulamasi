package com.eergun.mobilet.dto.request;

import com.eergun.mobilet.entity.enums.VehicleType;


public record AddVehicleRequestDto(
		String vehicleSerialNo,
		VehicleType type
) {
}