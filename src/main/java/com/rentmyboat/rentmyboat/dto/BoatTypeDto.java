package com.rentmyboat.rentmyboat.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoatTypeDto {
    private Long id;
    private String name;
}
