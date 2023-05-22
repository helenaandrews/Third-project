package com.rentmyboat.rentmyboat.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "boat_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoatType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
