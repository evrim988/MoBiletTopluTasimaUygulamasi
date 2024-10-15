package com.eergun.mobilet.mapper;

import com.eergun.mobilet.dto.request.AddVehicleRequestDto;
import com.eergun.mobilet.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleMapper {
	VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);
	
	Vehicle fromAddRequest(AddVehicleRequestDto dto);
}