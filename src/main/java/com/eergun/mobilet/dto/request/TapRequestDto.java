package com.eergun.mobilet.dto.request;

import com.eergun.mobilet.utility.enums.VehicleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TapRequestDto {
	@NotBlank
	String serialNumber;
	@NotNull
	VehicleType vehicleType;
	
}