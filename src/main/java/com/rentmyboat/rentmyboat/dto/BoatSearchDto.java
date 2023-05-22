package com.rentmyboat.rentmyboat.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoatSearchDto {

    private Long categoryId;
    private Integer capacityMin;
    private Integer capacityMax;
    private Integer cabinsMin;
    private Integer cabinsMax;
    private Integer bedsMin;
    private Integer bedsMax;
    private Integer lengthMin;
    private Integer lengthMax;
    private Double weekPriceMin;
    private Double weekPriceMax;
    private Double captainSalaryPerDayMin;
    private Double captainSalaryPerDayMax;
    private Integer yearMin;
    private Integer yearMax;
    private String manufacturer;
    private String model;
    private String enginePowerMin;
    private String enginePowerMax;
}
