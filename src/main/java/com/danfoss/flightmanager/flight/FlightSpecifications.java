package com.danfoss.flightmanager.flight;

import com.danfoss.flightmanager.airplane.Airplane;
import com.danfoss.flightmanager.airport.Airport;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;


public class FlightSpecifications {

    public static Specification<Flight> getByStatus(String flightStatus){
        return (root, query, criteriaBuilder) -> {
            if(StringUtils.isEmpty(flightStatus)){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("status"), FlightStatus.valueOf(flightStatus));
        };
    }

    public static Specification<Flight> getByAirportCode(String airportCode){
        return (root, query, criteriaBuilder) -> {
            if(StringUtils.isEmpty(airportCode)){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            Join<Flight, Airport> flightAirport = root.join("airport");
            return criteriaBuilder.equal(flightAirport.get("code"), airportCode);
        };
    }

    public static Specification<Flight> getByAirplaneCode(String airplaneCode){
        return (root, query, criteriaBuilder) -> {
            if(StringUtils.isEmpty(airplaneCode)){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            Join<Flight, Airplane> flightAirplane = root.join("airplane");
            return criteriaBuilder.equal(flightAirplane.get("code"), airplaneCode);
        };
    }
}
