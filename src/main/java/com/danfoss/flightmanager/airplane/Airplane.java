package com.danfoss.flightmanager.airplane;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "airplane")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    @Enumerated(EnumType.STRING)
    private AirplaneType type;
    private Integer capacity;
}
