package com.danfoss.flightmanager.flight;

import com.danfoss.flightmanager.airplane.Airplane;
import com.danfoss.flightmanager.airport.Airport;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.activation.DataSource;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FlightsRepository flightsRepository;

    @Test
    public void givenFlightStatusScheduled_thenReturnFlightList() throws Exception {

        Flight flight = Flight.builder().status(FlightStatus.SCHEDULED).build();
        when(flightsRepository.findAll(any(Specification.class))).thenReturn(Arrays.asList(flight));

        MvcResult result = mockMvc.perform(get("/flights").queryParam("status", "SCHEDULED")).andReturn();
        Assertions.assertTrue(objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Flight>>() {}).contains(flight));
    }

    @Test
    public void givenFlightAirplaneB737_thenReturnFlightList() throws Exception {

        Flight flight = Flight.builder().airplane(Airplane.builder().code("B737").build()).build();
        when(flightsRepository.findAll(any(Specification.class))).thenReturn(Arrays.asList(flight));

        MvcResult result = mockMvc.perform(get("/flights").queryParam("airplaneCode", "B737")).andReturn();
        Assertions.assertTrue(objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Flight>>() {}).contains(flight));
    }

    @Test
    public void givenFlightAirportIsZRH_thenReturnFlightList() throws Exception {

        Flight flight = Flight.builder().airport(Airport.builder().code("ZRH").build()).build();
        when(flightsRepository.findAll(any(Specification.class))).thenReturn(Arrays.asList(flight));

        MvcResult result = mockMvc.perform(get("/flights").queryParam("airportCode", "ZRH")).andReturn();
        Assertions.assertTrue(objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Flight>>() {}).contains(flight));
    }
}
