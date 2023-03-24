package com.danfoss.flightmanager.flight;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FlightsService {

    private final FlightsRepository flightRepository;
    public List<Flight> getAllFlights(String status, String airportCode, String airplaneCode) {
        Specification<Flight> flightSpecification = Specification.where(
                FlightSpecifications.getByAirplaneCode(airplaneCode)
                        .and(FlightSpecifications.getByAirportCode(airportCode))
                        .and(FlightSpecifications.getByStatus(status))
        );
        return flightRepository.findAll(flightSpecification);
    }

    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }
}
