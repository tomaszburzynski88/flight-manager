package com.danfoss.flightmanager.airplane;

import com.danfoss.flightmanager.error.FlightManagerRepositoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirplanesService {

    private final AirplaneRepository airplaneRepository;

    public void addPlane(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    public List<Airplane> getAllPlanes() {
        return airplaneRepository.findAll();
    }

    public Airplane getAirplaneByCode(String airplaneCode) {
        return airplaneRepository.findAirplaneByCode(airplaneCode).orElseThrow(()-> new FlightManagerRepositoryException(String.format("Can't find airplane with code: %s", airplaneCode)));
    }
}
