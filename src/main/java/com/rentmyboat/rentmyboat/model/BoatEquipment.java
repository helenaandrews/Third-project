package com.rentmyboat.rentmyboat.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "boat_equipment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoatEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "boat_id", nullable = false)
    private Boat boatId;

    @Column(name = "tent", nullable = false)
    private boolean tent;

    @Column(name = "visor", nullable = false)
    private boolean visor;

    @Column(name = "shower_on_deck", nullable = false)
    private boolean shower_on_deck;

    @Column(name = "dinner_table", nullable = false)
    private boolean dinner_table;

    @Column(name = "stereosystem", nullable = false)
    private boolean stereosystem;

    @Column(name = "pillows_for_cabin", nullable = false)
    private boolean pillows_for_cabin;

    @Column(name = "teak_deck", nullable = false)
    private boolean teak_deck;

    @Column(name = "bathing_platform", nullable = false)
    private boolean bathing_platform;

    @Column(name = "ladder_for_swimming", nullable = false)
    private boolean ladder_for_swimming;

    @Column(name = "hot_water", nullable = false)
    private boolean hot_water;

    @Column(name = "conditioner", nullable = false)
    private boolean conditioner;

    @Column(name = "fan", nullable = false)
    private boolean fan;

    @Column(name = "heating", nullable = false)
    private boolean heating;

    @Column(name = "electric_bathroom", nullable = false)
    private boolean electric_bathroom;

    @Column(name = "usb_socket", nullable = false)
    private boolean usb_socket;

    @Column(name = "dinghy", nullable = false)
    private boolean dinghy;

    @Column(name = "bow_thruster", nullable = false)
    private boolean bow_thruster;

    @Column(name = "electric_windlass", nullable = false)
    private boolean electric_windlass;

    @Column(name = "electric_winches", nullable = false)
    private boolean electric_winches;

    @Column(name = "autopilot", nullable = false)
    private boolean autopilot;

    @Column(name = "gps", nullable = false)
    private boolean gps;

    @Column(name = "echo_sounder", nullable = false)
    private boolean echo_sounder;

    @Column(name = "vhf", nullable = false)
    private boolean vhf;

    @Column(name = "maps_and_gides", nullable = false)
    private boolean maps_and_gides;

    @Column(name = "fridge", nullable = false)
    private boolean fridge;

    @Column(name = "tableware", nullable = false)
    private boolean tableware;

    @Column(name = "oven", nullable = false)
    private boolean oven;

    @Column(name = "dishwasher", nullable = false)
    private boolean dishwasher;

    @Column(name = "snorkel_mask", nullable = false)
    private boolean snorkel_mask;

    @Column(name = "fishing_gear", nullable = false)
    private boolean fishing_gear;

    @Column(name = "camping_gear", nullable = false)
    private boolean camping_gear;

    @Column(name = "camp_bath", nullable = false)
    private boolean camp_bath;

    @Column(name = "generator", nullable = false)
    private boolean generator;

    @Column(name = "solar_panels", nullable = false)
    private boolean solar_panels;

    @Column(name = "invertor", nullable = false)
    private boolean invertor;

    @Column(name = "v_220", nullable = false)
    private boolean v_220;

    @Column(name = "kinds_protective_mash", nullable = false)
    private boolean kinds_protective_mash;

    @Column(name = "clean_bedlinen", nullable = false)
    private boolean clean_bedlinen;

    @Column(name = "clean_towels", nullable = false)
    private boolean clean_towels;

    @Column(name = "wifi", nullable = false)
    private boolean wifi;

    @Column(name = "outboard_engine", nullable = false)
    private boolean outboard_engine;

    @Column(name = "sup_board", nullable = false)
    private boolean sup_board;

    @Column(name = "gannaker", nullable = false)
    private boolean gannaker;

    @Column(name = "other")
    private String other;
}
