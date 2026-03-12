package com.example.event_ticketing.entity;

import com.example.event_ticketing.enums.EventStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer event_id;

    @Column(nullable = false)
    private String title;

    private LocalDateTime event_date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatus status;

    @Column(nullable = true)
    private String description;

    // relationships
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    // maybe change var
    private List<TicketType> type;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;
}
