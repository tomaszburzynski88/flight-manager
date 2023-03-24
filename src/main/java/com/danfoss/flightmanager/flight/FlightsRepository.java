package com.danfoss.flightmanager.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FlightsRepository extends JpaRepository<Flight, Integer>, JpaSpecificationExecutor {

}
