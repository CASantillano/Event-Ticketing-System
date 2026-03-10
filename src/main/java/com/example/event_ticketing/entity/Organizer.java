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
    private String phone;

    // relationship
    // need to do events

    // do @ManyToOne
    // @JoinColumn(name = "organizer_id") in events to finish relationship
    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<Event> events;
}
