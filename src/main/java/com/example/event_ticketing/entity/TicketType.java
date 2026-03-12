package com.example.event_ticketing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TicketType")
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticket_type_id;

    @Column(nullable = false)
    // tier name
    private String name;

    private Integer quantity_available;

    // maybe double?
    @Column(columnDefinition = "DECIMAL(7, 2) CHECK (price >= 0.0)", nullable = false)
    private Double price;

    // relationship
    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;
}
