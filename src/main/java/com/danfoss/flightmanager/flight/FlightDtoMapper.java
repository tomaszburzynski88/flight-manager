package com.danfoss.flightmanager.flight;

import com.danfoss.dto.FlightDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface FlightDtoMapper {

    List<FlightDto> flightListToFlightDtoList(List<Flight> flightList);

    Flight flightDtoToFlight(FlightDto flightDto);
}
