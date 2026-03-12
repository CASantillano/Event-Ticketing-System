package com.example.event_ticketing.entity;

import jakarta.persistence.*;
import java.util.List;

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
    @Column(columnDefinition = "DECIMAL(7, 2) CHECK (price >= 0.0)")
    private Double price;

    // relationship
    //check
    @ManyToOne
    @JoinColumn(name="event_id")
}
