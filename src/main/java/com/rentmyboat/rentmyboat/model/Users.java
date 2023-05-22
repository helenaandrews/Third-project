package com.rentmyboat.rentmyboat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    @Size(min = 6, max = 32, message  = "username from 6 to 32 symbols")
    private String username;

    @Column(name = "password", nullable = false)
    @Size(min = 6, max = 32, message  = "password from 6 to 32 symbols")
    private String password;

    @Column(name = "role", nullable = false)
    @NotBlank(message = "roles must be boat_owner or boat_renter")
    private String role;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "photo_link", nullable = false)
    private String photoLink;

    @Column(name = "birth_date", nullable = false)
    private Timestamp birthDate;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @OneToMany(mappedBy = "user_id")
    private List<Booking> bookings;
}