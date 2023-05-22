package com.rentmyboat.rentmyboat.dto;

import com.rentmyboat.rentmyboat.model.Boat;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoatDto {
    private Long id;
    private Long userId;
    private Long boatTypeId;
    private Long boatCategoryId;
    private Double length;
    private Integer cabins;
    private Integer beds;
    private Integer people;
    private Long capacity;
    private Long enginePower;
    private Integer year;
    private String manufacturer;
    private String model;
    private String portAddress;
    private Double weekPrice;
    private Double dayPrice;
    private Double captainSalaryPerDay;
    private Long withCaptain;
    private boolean hasEngine;
    private boolean hasSail;
    private String photoLinks;
    private String requiredLicense;
}
