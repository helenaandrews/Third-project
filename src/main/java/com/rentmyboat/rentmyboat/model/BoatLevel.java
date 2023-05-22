package com.rentmyboat.rentmyboat.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "boat_level")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoatLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
