package com.example.event_ticketing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Venue")
@Data
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venue_id")
    private Integer venueId;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Address is required")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "City is required")
    @Column(nullable = false)
    private String city;

    @Positive
    @Column(nullable = false)
    private Integer totalCapacity;

    // relationship
    // venue -> event = one to many
    // event -> venue = joinColumn(name = "venue_id") many to one
    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Event> events;
}
