package com.example.event_ticketing.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Venue")
@Data
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer venue_id;

    @Column(nullable = false)
    private String name;

    private String address;

    private String city;

    private Integer total_capacity;

    // relationship
    // venue -> event = one to many
    // event -> venue = joinColumn(name = "venue_id") many to one
    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    private List<Event> events;
}
