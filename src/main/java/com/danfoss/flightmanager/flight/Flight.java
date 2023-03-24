package com.danfoss.flightmanager.flight;

import com.danfoss.flightmanager.airplane.Airplane;
import com.danfoss.flightmanager.airport.Airport;
import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.Duration;
import java.time.OffsetDateTime;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private OffsetDateTime departure;
    private OffsetDateTime arrival;
    @Type(PostgreSQLIntervalType.class)
    private Duration duration;
    @Enumerated(EnumType.STRING)
    private FlightStatus status;
    @ManyToOne
    @JoinColumn(name = "airport_id", nullable = false)
    private Airport airport;
    @ManyToOne
    @JoinColumn(name = "airplane_id", nullable = false)
    private Airplane airplane;
}
