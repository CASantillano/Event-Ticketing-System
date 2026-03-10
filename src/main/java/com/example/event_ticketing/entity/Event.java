package com.example.event_ticketing.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer event_id;

    @Column(nullable = false)
    private String title;

    // date
    // datetime?... event_date;

    // status
    // enum ... status;

    @Column(nullable = true)
    private String description;

    // relationships
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    // maybe change var
    private List<TicketType> type;

    //check syntax, and match to 3.3 schema
    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;
    @JoinColumn(name = "venue_id")
    private Venue venue;
}
