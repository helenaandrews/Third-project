package com.rentmyboat.rentmyboat.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resume")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="boat_level_id")
    private BoatLevel boat_level_id;

    @ManyToOne
    @JoinColumn(name="boat_type_id")
    private BoatType boat_type_id;

    @Column(name = "shore")
    private boolean shore;

    @Column(name = "open_sea")
    private boolean open_sea;

    @Column(name = "radio")
    private boolean radio;

    @Column(name = "licensed_skipper")
    private boolean licensed_skipper;

    @Column(name = "rented_before")
    private boolean rented_before;

    @Column(name = "info_about", nullable = false)
    private String info_about;
}
