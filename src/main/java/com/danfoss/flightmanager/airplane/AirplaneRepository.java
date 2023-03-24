package com.danfoss.flightmanager.airplane;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
    Optional<Airplane> findAirplaneByCode(String airplaneCode);
}
