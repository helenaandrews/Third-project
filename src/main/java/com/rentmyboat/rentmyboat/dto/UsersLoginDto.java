package com.rentmyboat.rentmyboat.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersLoginDto {
    private String username;
    private String password;
}
