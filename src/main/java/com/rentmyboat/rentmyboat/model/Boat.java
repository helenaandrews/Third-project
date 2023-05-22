package com.rentmyboat.rentmyboat.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "boat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "boat_type_id")
    private BoatType boatType;

    @ManyToOne
    @JoinColumn(name = "boat_category_id")
    private BoatCategory boatCategory;

    @Column(name = "length", nullable = false)
    private Double length;

    @Column(name = "cabins", nullable = false)
    private Integer cabins;

    @Column(name = "beds", nullable = false)
    private Integer beds;

    @Column(name = "people", nullable = false)
    private Integer people;

    @Column(name = "capacity", nullable = false)
    private Long capacity;

    @Column(name = "engine_power", nullable = false)
    private Long enginePower;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "port_address", nullable = false)
    private String portAddress;

    @Column(name = "week_price")
    private Double weekPrice;

    @Column(name = "day_price")
    private Double dayPrice;

    @Column(name = "captain_salary_per_day")
    private Double captainSalaryPerDay;

    @ManyToOne
    @JoinColumn(name = "with_captain", nullable = false)
    private WithCaptain withCaptain;

    @Column(name = "has_engine", nullable = false)
    private boolean hasEngine;

    @Column(name = "has_sail", nullable = false)
    private boolean hasSail;

    @Column(name = "photo_links")
    private String photoLinks;

    @Column(name = "required_license")
    private String requiredLicense;
}