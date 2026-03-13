package com.example.event_ticketing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "TicketType")
@Data
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticket_type_id;

    @Column(nullable = false)
    // tier name
    private String name;

    private Integer quantity_available;

    @PositiveOrZero
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal price;

    // relationship
    @ManyToOne
    @JoinColumn(name="event_id", nullable = false)
    private Event event;
}
