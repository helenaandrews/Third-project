package com.rentmyboat.rentmyboat.dto;

import com.rentmyboat.rentmyboat.model.Booking;
import com.rentmyboat.rentmyboat.model.Resume;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class UsersDto {
    private Long id;
    private boolean isActive;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String photoLink;
    private Long birthDate;
    private String postalCode;
    private String country;
    private String city;
    private Resume resumeId;
    private List<Booking> bookings;
}