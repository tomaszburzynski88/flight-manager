package com.danfoss.flightmanager.airport;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String city;
    @Enumerated(EnumType.STRING)
    private Nation nation;
}
