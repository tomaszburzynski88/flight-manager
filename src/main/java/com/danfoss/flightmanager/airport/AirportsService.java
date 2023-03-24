package com.danfoss.flightmanager.airport;

import com.danfoss.flightmanager.error.FlightManagerRepositoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportsService {

    private final AirportRepository airportRepository;

    public Airport getAirportByCode(String airportCode){
        return airportRepository.findAirportByCode(airportCode).orElseThrow(()-> new FlightManagerRepositoryException(String.format("Can't find airport by code: %s", airportCode)));
    }
}
