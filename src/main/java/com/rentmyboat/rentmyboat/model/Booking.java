package com.rentmyboat.rentmyboat.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.RouteMatcher;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="boat_id", nullable = false)
    private Route boat_id; // связь с лодками по таблице route (краткая информация по лодке)

    //TODO на стороне Users должно быть указано mappedBy = "user_id". Расскомментировать, как будут Users
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Users user_id; // связь с таблице users

    @Column(name = "start_date", nullable = false)
    private LocalDate start_date;

    @Column(name = "end_date", nullable = false)
    private LocalDate end_date;

    @Column(name = "total_cost", nullable = false)
    private Double total_cost;


}
