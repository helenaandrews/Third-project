package com.rentmyboat.rentmyboat.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "insurance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="boat_id", nullable = false)
    private Boat boat_id;

    @Column(name = "company_name", nullable = false)
    private String company_name;

    @Column(name = "certificate_number", nullable = false)
    private String certificate_number;

    @Column(name = "certificate_photo_link")
    private String certificate_photo_link;
}
