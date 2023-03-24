package com.danfoss.flightmanager.airplane;

import com.danfoss.dto.AirplaneDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface AirplaneDtoMapper {

    Airplane airplaneDtoToAirplane(AirplaneDto airplaneDto);

    AirplaneDto airplaneToAirplaneDto(Airplane airplane);

    List<AirplaneDto> airplaneListToAirplaneDtoList(List<Airplane> airplaneList);
}
