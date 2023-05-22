package com.rentmyboat.rentmyboat.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoatCategoryDto {
    private Long id;
    private String name;
}
