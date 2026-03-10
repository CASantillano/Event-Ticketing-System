package com.example.event_ticketing.entity;

import jakarta.persistence.*;
import java.util.List;
// look into using lombok, or manually do getters/setters

@Entity
@Table(name="Organizer")
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organizer_id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Column(nullable = true)
    // maybe change from string to int/number?
    private String phone;

    // relationship
    // need to do events

    //@OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    //private List<Event> events;
}
