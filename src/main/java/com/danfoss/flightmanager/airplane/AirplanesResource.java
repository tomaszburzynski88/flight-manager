package com.danfoss.flightmanager.airplane;

import com.danfoss.api.AirplanesApi;
import com.danfoss.dto.AirplaneDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AirplanesResource implements AirplanesApi {

    private final AirplanesService airplanesService;
    private final AirplaneDtoMapper airplaneDtoMapper;


    @Override
    public ResponseEntity<Void> addPlane(AirplaneDto airplaneDto){
        airplanesService.addPlane(airplaneDtoMapper.airplaneDtoToAirplane(airplaneDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<AirplaneDto>> getAirplanes(){
        return ResponseEntity.ok(airplaneDtoMapper.airplaneListToAirplaneDtoList(airplanesService.getAllPlanes()));
    }
}
