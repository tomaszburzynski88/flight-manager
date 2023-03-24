package com.danfoss.flightmanager.flight;

import com.danfoss.api.FlightsApi;
import com.danfoss.dto.FlightDto;
import com.danfoss.dto.NewFlightDto;
import com.danfoss.flightmanager.airplane.Airplane;
import com.danfoss.flightmanager.airplane.AirplanesService;
import com.danfoss.flightmanager.airport.Airport;
import com.danfoss.flightmanager.airport.AirportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlightsResource implements FlightsApi {

    private final FlightsService flightsService;
    private final AirportsService airportService;
    private final AirplanesService airplanesService;
    private final FlightDtoMapper flightDtoMapper;

    @Override
    public ResponseEntity<Void> addNewFlight(NewFlightDto newFlightDto){
        Airport airport = airportService.getAirportByCode(newFlightDto.getAirportCode());
        Airplane airplane = airplanesService.getAirplaneByCode(newFlightDto.getAirplaneCode());
        Flight flight = Flight.builder()
                .airplane(airplane)
                .airport(airport)
                .arrival(newFlightDto.getArrival())
                .departure(newFlightDto.getDeparture())
                .status(FlightStatus.SCHEDULED)
                .number(newFlightDto.getNumber())
                .duration(Duration.between(newFlightDto.getDeparture(), newFlightDto.getArrival()))
                .build();
        flightsService.addFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<FlightDto>> getAllFlights(String status, String airportCode, String airplaneCode){
        return ResponseEntity.ok(flightDtoMapper.flightListToFlightDtoList(flightsService.getAllFlights(status, airportCode, airplaneCode)));
    }
}
