package com.eergun.mobilet.dto.request;

import com.eergun.mobilet.entity.enums.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


public record TapRequestDto(
		@NotBlank
		String cardSerialNumber,
		@NotNull
		VehicleType vehicleType,
		@NotBlank
		@Size(min = 6, max = 6)
		String vehicleSerialNo) {
}