package com.example.event_ticketing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Attendee")
@Data
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendee_id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    // relationship
    @OneToMany(mappedBy = "attendee", cascade = CascadeType.ALL)
    private List<Booking> bookings;
}
